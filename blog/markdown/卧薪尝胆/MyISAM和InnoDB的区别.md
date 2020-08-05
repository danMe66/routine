# MyISAM和InnoDB的区别

MyISAM 强调的是性能，查询速度快，支持表锁，支持全文索引，并发较小，不支持事务型操作，不支持外键，崩溃后不可自动恢复
InnoDB 适合频繁修改以及设计安全性较高的应用，支持行锁，不支持全文索引，并发较大，支持事务型操作，支持外键，奔溃可恢复
对于 `select count(*) from table` 语句，MyISAM 比 InnoDB 快，因为 MyISAM 直接会保存表行数，在查询的时候直接取出，但是InnoDB 会遍历整个表来计算行
对于加了where条件，`select count(*) from table where 条件`，两者都会进行遍历计算行数。





 **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**