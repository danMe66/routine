# 线上问题排查-MySQL篇

[TOC]



## （一）死锁

### 问题原因

随着线上流量的变大，突然开始报如下异常，就是发生了死锁问题：

```mysql
Deadlock found when trying to get lock; try restarting transaction ;
```

### 问题分析

查询事务的隔离级别

利用 `select @@tx_isolation` 命令获取到数据库隔离级别信息。

![](https://cdn.phpmianshi.cn/PicGo/20201110090224.png)

查询数据库的死锁日志，利用 `show engine innodb status` 命令获取到如下死锁信息：

![](https://cdn.phpmianshi.cn/PicGo/20201110090308.png)

![](https://cdn.phpmianshi.cn/PicGo/20201110090320.png)

由上可知，是由于两个事物对这条记录同时持有S锁(共享锁)的情况下，再次尝试获取该条记录的X锁(排它锁)，从而导致互相等待引发死锁

### 获得结论

分析获得产生问题的加锁时如下，然后修改代码以解决该问题。

![](https://cdn.phpmianshi.cn/PicGo/20201110090627.png)



## （二）慢SQL

### 问题出现

应用的 TPS 下降，并出现 SQL 执行超时异常或者出现了类似如下的告警信息，则常常意味着出现了慢 SQL。

![](https://cdn.phpmianshi.cn/PicGo/20201110090851.png)

### 问题分析

分析执行计划：利用 explain 指令获得该 SQL语句的执行计划，根据该执行计划，可能有两种场景。

- SQL 不走索引或扫描行数过多等，导致执行时长过长
- SQL 没问题，只是因为事务并发导致等待锁，导致执行时长过长

#### 场景一（SQL 不走索引或扫描行数过多等，导致执行时长过长）的解决方案

##### 优化SQL

通过增加索引，调整 SQL 语句的方式优化执行时长，例如以下执行计划：

![](https://cdn.phpmianshi.cn/PicGo/20201110091527.png)

该 SQL 的执行计划的 TYPE 为 ALL，同时根据以下 type 予以，可知无索引的全表查询，可以判断为其检索列增加索引可以解决。

![](https://cdn.phpmianshi.cn/PicGo/20201110091706.png)

#### 场景二（SQL 没问题，只是因为事务并发导致等待锁，导致执行时长过长）的解决方案

#### 查询当前事务情况

可以通过查看如下3张表做相应的处理：

```mysql
-- 当前运行的所有事务
SELECT *  FROM information_schema.innodb_trx;
-- 当前出现的锁
SELECT * FROM information_schema.INNODB_LOCKS;
-- 锁等待的对应关系
SELECT *  FROM information_schema.INNODB_LOCK_WAITS;
```

###### （1）查看当前的事务有哪些：

![](https://cdn.phpmianshi.cn/PicGo/20201110092302.png)

###### （2）查看事务锁类型索引的详细信息：

![](https://cdn.phpmianshi.cn/PicGo/20201110092351.png)

look_table 字段能看到被锁的索引的表名，lock_model 可以看到锁类型是 X 锁，lock_type 可以看到是行锁 record 。

#### 分析

根据事务情况，得到表信息，和相关的事务时序信息：

```mysql
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`salary` int(10) DEFAULT NULL,
`name` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `idx_name` (`name`(191)) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
```

A事务锁住一条记录，不提交，B事务需要更新此条记录，此时会阻塞，如下图是执行顺序：

![](https://cdn.phpmianshi.cn/PicGo/20201110092720.png)

#### 解决方案

##### （一）修改方案

由前一步的结果，分析事务间加锁时序，例如可以通过 tx_query 字段得知被阻塞的事务 SQL，trx_state 得知事务状态等，找到对应的代码逻辑，进行优化修改。

##### （二）临时修改方案

trx_mysql_thread_id 是对应的事务 sessionId，可以通过以下命令杀死上时间执行的命令，从而避免阻塞其他事务执行。

```shell
kill 105853
```



## （三）连接数过多

### 问题出现

常出现 `too manyconnections ` 异常，数据库连接到达最大连接数。

### 解决方案

解决方案

- 通过 `set global max_connections=XXX` 增大最大连接数
- 先利用 `show processlist` 获取连接信息，然后利用 kill 杀死过多的连接

常用脚本如下

```mysql
排序数据库连接的数目 
mysql -h127.0.0.0.1 -uabc_test -pXXXXX -P3306 -A -e 'show processlist'| awk '{print $4}'|sort|uniq -c|sort -rn|head -10
```







 **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**