# mysql 索引类型

## 1：普通索引

这是最基本的索引，它没有任何限制，比如某个字段创建的索引就是一个普通索引，MyISAM 默认的 BTREE 类型的索引，也是我们大多数情况下用到的索引。

直接创建索引

```sql
CREATE INDEX index_name ON TABLE(column(lehgth))
```

修改表结构的方式添加索引

```sql
ALTER TABLE table_name ADD INDEX index_name ON (column(length))
```

创建表的时候同时创建索引

```sql
CREATE TABLE 'TABLE' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'title' char(255) CHARACTER SET UTF8 COLLATE utf8_general_ci NOT NULL,
  'content' text CHARACTER SET UTF8 COLLATE utf8_general_ci NOT NULL,
  'time' int(10) NULL DEFAULT NULL,
PRIMARY KEYo('id'),
INDEX index_name(title(length))
)
```

删除索引

```sql
DROP INDEX INDEX_NAME ON table
```



## 2：唯一索引

与普通索引类似，不同的就是：索引列的值必须唯一，但允许有空值（注意和主键不同）。如果是组合索引，则列值得组合必须唯一，创建方法和普通索类似。

创建唯一索引

```sql
CREATE UNIQUE INDEX index_name ON TABLE(columm(length))
```

修改表结构

```sql
ALTER TABLE table_name ADD UNIQUE index_name ON (column(length))
```

创建表的时候直接指定

```sql
CREATE TABLE 'TABLE'(
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'title' char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  'content' text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  'time' int(10) NULL DEFAULT NULL,
PRIMARY KEY('id'),
UNIQUE index_name (titlt(length))
)
```





## 3：全文索引

对于较大的数据集，将你的资料输入一个没有 FULLTEXT 索引的表中，然后创建索引，其速度比把资料输入现有 FULLTEXT索引的速度更为快。不过对于大容量的数据表，生成全文索引是一个消耗时间非常消耗硬盘空间的做法。

创建表的时候添加全文索引

```sql
CREATE TABLE 'TABLE'(
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'title' char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  'content' text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  'time' int(10) NULL DEFAULT NULL,
  PRIMARY KEY ('id'),
  FULLTEXT (content)
)
```

修改表结构添加全文索引

```sql
ALTER TABLE article ADD FULLTEXT index_content(content)
```

直接创建索引

```sql
CREATE FULLTEXT INDEX index_content ON article(content)
```



## 4：单列索引、多列索引

多个单列索引与单个单列索引的查询效果不同，因为执行查询时，MySQL 只能使用一个索引，会从多个索引中选择一个限制最为严格的索引。

## 

## 5：组合索引（最左前缀）

平时用的 SQL 查询语句一般都有比较多的限制条件，所以为了进一步榨取 MySQL 的效率，就要考虑简历组合索引。

比如：针对 title 和 time 建立一个组合索引

```sql
ALTER TABLE article ADD INDEX index_title_time(title(50),time(10))
```

建立这样的组合索引，其实相当于分别建立了下面两组组合索引：

```sql
-title,time
-title
```

为什么没有 time 这样的组合索引呢？这是因为 MySQL 组合索引“最左前缀”的结果。简单理解就是只从最左面的开始组合。并不是只要包含这两列的查询都会用到该组合索引，如下面几个 SQL 所示：

```sql
-- 使用上面的索引
SELECT * FROM article WHERE title='测试' AND time=123456789;
SELECT * FROM article WHERE title='测试';
-- 不适用上面的索引
SELECT * FROM article WHERE time=123456789;
```



## MySQL 索引的优化

上面都在说使用索引的好处，但过多的使用索引将会造成滥用。因此索引也会有其它的缺点：虽然索引大大提高了查询速度，同时却会降低更新表的速度，如对表进行 INSERT、UPDATE、DELETE。因为更新表时，MySQL 不仅要保存数据，还要保存一下索引文件。建立索引文件会占用磁盘空间的索引文件。一般情况下这个问题不太严重，但如果你在一个大表中创建了多种组合索引，索引文件会膨胀的很快。索引只是提高效率的一个因素，如果你的 MySQL 有大数据量的表，就需要花时间研究建立最优秀的索引，或优化查询语句。

### 1：何时使用聚集索引或非聚集索引？

| 动作描述           | 使用聚集索引 | 使用非聚集索引 |
| ------------------ | ------------ | -------------- |
| 列经常被分组排序   | 使用         | 使用           |
| 返回某范围内的数据 | 使用         | 不使用         |
| 一个或极少不同值   | 不使用       | 不使用         |
| 小数目的不同值     | 使用         | 不使用         |
| 大数目的不同值     | 不使用       | 使用           |
| 频繁更新的列       | 不使用       | 使用           |
| 外键列             | 使用         | 使用           |
| 主键列             | 使用         | 使用           |
| 频繁修改索引列     | 不使用       | 使用           |

还需再研究下....



### 2：索引不会包含有 null 值得列

只要列中包含有 null 值都将不会被包含在索引中，复合索引中只要有一列含有 null 值，那么这一列对于此复合索引就是无效的。所以我们在数据库设计时不要让字段的默认值为 NULL。

### 3：使用短索引

对串列进行索引，如果可能应该指定一个前缀长度。例如：

如果有一个 CHAR(255) 的列，如果在前10个或20个字符内，多数值是唯一的，那么就不要对整个列进行索引。短索引不仅可以提高查询速度而且还可以节省磁盘空间和 I/O 操作。

### 4：索引列排序

MySQL 查询只使用一个索引，因此如果 where 子句中已经使用了索引的话，那么 order by 中的列是不会使用索引的。因此数据库默认排序可以符合要求的情况下不要使用排序操作；尽量不要包含多个列的排序，如果需要最好给这里写列创建符合索引。

### 5：like 语句操作

一般情况下不鼓励使用 like 操作，如果非使用不可，如何使用也是一个问题，比如：

`like "%aaa%"` 不会使用索引而 `like "aaa%"` 可以使用索引。

### 6：不要在列上使用运算

例如：

```sql
SELECT * FROM users WHERE YEAR(adddate) < 2007
```

这个将在每个行上进行运算，导致索引失效而进行全表扫描，因此我们可以改成

```sql
SELECT * FROM users where adddate < '2007-01-01'
```

> 欣赏：[一个单引号引发的MYSQL性能损失](https://www.zendstudio.net/archives/single-quotes-or-no-single-quotes-in-sql-query/)

### 总结：

MySQL 只对以下操作符才使用索引：

<、<=、=、>、>=、between、in，以及某些时候的 like（不以通配符%或_开头的情形）。而理论上每张表里面最多可创建16个索引，不过除非数据是真的多，否则过多使用索引也不行。





 **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**