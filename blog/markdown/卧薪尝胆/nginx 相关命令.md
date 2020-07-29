# nginx 相关命令

查看 nginx 进程是否存在（查看 nginx 占用进程）

```
ps -ef | grep nginx
ps aux |grep nginx
```

直接启动（启动 nginx 服务）

```
ngixn
```

systemctl 命令启动（linux 命令启动 nginx 服务）

```
systemctl start nginx.service
```

根据进程id重启进程

```
kill -HUP 2072
```

查看启动后记录（查看 nginx 占用进程）

```
ps aux | grep nginx
```

停止 nginx 服务（进程完成当前工作后再停止）

```
nginx -s quit
```

立即停止 nginx 服务（无论进程是否在工作，直接停止）

```
nginx -s stop
```

systemctl 命令停止（linux 命令停止 nginx 服务）

```
systemctl stop nginx.service
```

killall 杀死进程

```
killall nginx
```

根据进程id杀死进程

```
kill -QUIT 2072
```

重新载入配置文件

```
nginx -s reload
```

检查 nginx 配置文件文件是否有误

```
nginx -t
```

查看全部端口号（查看机器上全部运行的端口号）

```
netstat -tlnp
```

直接查看进程id（查看指定进程名称的进程id）

```
ps -C nginx -o pid
```

使用lsof命令查看端口（可以查到指定端口是否有进程在运行）

```
lsof -i:80
```