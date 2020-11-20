# mysql索引和存储引擎

## 索引

### MySQL 不同的存储引擎

![](https://cdn.phpmianshi.cn/PicGo/20201110143846.png)

### InnoDB B+Tree 索引实现

主键索引（聚集索引）：

- 叶子节点 data 域保存了完整的数据的地址
- 主键和数据完全存在一棵树上
- Root 节点常驻内存
- 每个非叶子节点一个 innodb_page_size 大小，加速磁盘 IO
- 磁盘的 IO 要比内存慢几百倍，而磁盘慢的原因在于机械设备寻找磁盘慢，因此采用磁盘预读，每次读取一个磁盘页（page：计算机管理存储器的逻辑快-通常为4k）的整倍数
- 如果没有主键，MySQL 默认生成隐含字段作为主键，这个字段长度为6个字节，类型为长整形
- 辅助索引结构和主索引相同，但叶子节点 data 域保存的是主键指针
- InnnoDB 以表空间 Tablespace（idb文件）结构进行组织，每个 Tbalespace包含多个 Segment 段
- 每个段（分为2种段：叶子节点 Segment & 非叶子节点 Segment），一个 Segment 段包含多个 Extent
- 一个 Extent 占用 1M 空间包含64个 Page（每个Page 16k）,InnoDB B-Tree 一个逻辑节点就分配一个物理 Page，一个节点一次 IO 操作
-  一个 Page 里包含很多有序数据 Row 行数据，Row行数据中包含 Filed 属性数据等信息

InnoDB 存储引擎中页的大小为 16KB，一般表的主键类型为 INT（占用4个字节）或 BIGINT（占用8个字节），指针类型也一般为4或8个字节，也就是说一个页（B+Tree中的节点）中大概存储16KB/(8B+8B)=1k个键值（因为是估值，为方便计算，这里的K的取值为[10]^3）.

也就是说一个深度为3的B+Tree 索引可以维护 10^3 * 10^3 * 10^3=10亿条记录。

![](https://cdn.phpmianshi.cn/PicGo/20201110150352.png)

每个索引的左指针都是比自己小的索引/节点，右指针是大于自己的索引/节点。







 **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**