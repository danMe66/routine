# mysql基础-使用mysqldump备份

## 如何备份数据库

### 语法

```shell
mysqldump [arguments] > file_name
```

### 要转储所有数据库，请使用以下选项调用

```shell
mysqldump --all-databases > dump.sql
```

### 要仅转储特定数据库，请在命令行上命名它们并使用以下

```shell
mysqldump --databases db1 db2 db3 > dump.sql
```

### 要转储单个数据库，请在命令行上将其命名

```shell
mysqldump --databases test > dump.sql
```

### 在单数据库情况下，可以忽略以下 --databases 选项

```shell
mysqldump test > dump.sql
```

### 要仅转储数据库中的特定表，请在数据库名称后的命令行中将其命名

```shell
mysqldump test t1 t3 t7 > dump.sql
```

### 备份到当前的目录（在对应目录下执行以下命令）

```shell
mysqldump -u root -p --opt database > database.sql
```

## 如何恢复数据库

### 语法

登录数据库

```shell
mysql -u root -p
```

进入对应的数据库

```mysql
use test;
```

执行恢复命令

```shell
source /source /tmp/test.sql
```

