# php-fpm 的三种运行模式

### 1：static 模式（静态模式）

static 模式始终会保持一个固定数量的子进程，这个数量由`pm.max_children` 的配置决定

### 2：dynamic 模式（动态模式）

子进程的数量是动态变化的，启动时，会生成固定数量的子进程，可以理解为最小子进程数，通过 `pm.statr_servers` 配置决定，而最大子进程数则由`pm.max_children` 控制，子进程数会在`pm.start_servers` ~ `pm.max_children` 范围内波动，另外，闲置的子进程数还可以由 `pm.min_spare_servers`和 `pm.max_spare_servers`两个配置参数控制。总结：闲置的子进程也可以有最小数目和最大数目，而如果闲置的子进程超过`pm.max_spare_servers`,则会别杀死。

### 3：ondemand 模式（动态需求模式）

这种模式和 dynamic 模式相反。因为这种模式把内存放在第一位，每个闲置进程在持续闲置了`pm.process_idle_timeout` 秒后就会被杀死，因为这种模式，到了服务器低峰期的时候，内存就会降下来，如果服务器长时间没有请求，就只有一个主进程。其弊端是，遇到高峰期或者`pm.process_idle_timeout` 设置太小，无法避免服务器频繁创建进程的问题。



## 涉及到的参数配置：

- `pm.max_children` ：静态方式下开启 php-fpm 进程数量
- `pm.start_servers`：动态方式下的起始 php-fpm 进程数量
- `pm.min_spare_servers`：动态方式下的最小 php-fpm 进程数量
- `pm.max_spare_servers`：动态方式下的最大 php-fpm 进程数量



## PHP-FPM 慢日志配置

配置文件：`php-fpm.conf`

开启慢日志查询：

```
slowlog = /usr/local/log/php-fpm.log.slow
request_slowlog_timeout = 5s
```

意思是当某个请求时间超过了5秒，就写进慢日志，注意是5s，别忘了单位。其他单位还有m分，h时，php-fpm会记录对应的进程号，脚本名称，具体执行慢的代码行好等。





​                                                                                                                                                                    **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**