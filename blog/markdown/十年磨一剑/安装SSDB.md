# 安装SSDB

## 什么是SSDB

一个高性能的支持丰富数据结构的 NoSQL 数据库, 用于替代 Redis.

## 特性

- 替代 Redis 数据库, Redis 的 100 倍容量
- LevelDB 网络支持, 使用 C/C++ 开发
- Redis API 兼容, 支持 Redis 客户端
- 适合存储集合数据, 如 list, hash, zset...
- 客户端 API 支持的语言包括: [C++](http://ssdb.io/docs/cpp/), [PHP](http://ssdb.io/docs/zh_cn/php/), Python, [Java](http://ssdb.io/docs/java/), Go
- 持久化的队列服务
- **主从复制, 负载均衡**

强烈推荐你把 SSDB 部署在 **Linux 操作系统**上.

不要在生产环境中使用 Windows 操作系统来运行 SSDB 服务器. 如果你确实必须使用 Windows 操作系统, 请在上面运行一个 Linux 虚拟机, 然后再让 SSDB 运行于这个虚拟机之中.

## 编译和安装

```shell
wget --no-check-certificate https://github.com/ideawu/ssdb/archive/master.zip
unzip master
cd ssdb-master
make
# 将安装在 /usr/local/ssdb 目录下
sudo make install
```

如果你想安装 ssdb 在其它的目录, 不在 `/usr/local` 目录下, 可以这样

```shell
sudo make install PREFIX=/your/direcotry
```

### 问题解决

如果出现如下错误:

```shell
g++ ...deps/snappy-1.1.0/.libs/libsnappy.a: No such file or directory
make[1]: *** [all] Error 1
```

或者

```shell
g++ ...deps/jemalloc-3.3.1/lib/libjemalloc.a: No such file or directory
make[1]: *** [all] Error 1
```

这是因为 Snappy 或者 Jemalloc 没有编译成功, 这一般是因为你的系统时钟有问题. 可以这样解决:

```shell
cd deps/snappy-1.1.0
autoreconf --force --install
./configure
make
```

或者

```shell
cd deps/jemalloc-3.3.1
autoreconf --force --install
./configure
make
```

## 启动和停止

```shell
# 启动主库, 此命令会阻塞住命令行
./ssdb-server ssdb.conf

# 或者启动为后台进程(不阻塞命令行)
./ssdb-server -d ssdb.conf

# 停止 ssdb-server
./ssdb-server ssdb.conf -s stop
# 对于旧版本
kill `cat ./var/ssdb.pid`

# 重启
./ssdb-server ssdb.conf -s restart
```

到目前为止, 你需要手动管理 `ssdb-server` 进程, 如果你希望在操作系统启动和停止时自动地管理, 请按下面的说明进行.

## SSDB 启动脚本(随操作系统自启动)

假设你已经安装 SSDB 在默认的 `/usr/local/ssdb` 目录, 把 `tools/ssdb.sh` 脚本放到 `/etc/init.d` 目录下.

注意: 对于 CentOS 用户, 请将 `ssdb.sh` 重命名为 `ssdb`.

编辑下面的内容:

```shell
# each config file for one instance
configs=/data/ssdb_data/test/ssdb.conf
```

将 `/data/ssdb_data/test/ssdb.conf` 修改为你的 SSDB 配置文件的路径. 如果你有多个 SSDB 实例, 那么把它们写在一行, 用空格来分隔, 例如:

```shell
# each config file for one instance
configs=/data/ssdb_data/test/ssdb.conf /data/ssdb_data/demo/ssdb.conf
```

**CentOS**

```shell
sudo chkconfig --add ssdb
sudo chkconfig ssdb on
```

**Ubuntu**

```shell
sudo chmod a+x /etc/init.d/ssdb.sh
sudo update-rc.d ssdb.sh defaults
```





## 资料:

- [中文官网](http://ssdb.io/zh_cn/)
- [从 Redis 迁移到 SSDB](http://ssdb.io/docs/zh_cn/redis-to-ssdb.html)