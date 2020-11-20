# Redis 设置密码

Redis 没有实现访问控制这个功能，但是它提供了一个轻量级的认证方式，可以编辑 `redis.conf` 配置来启用认证。

###    1、初始化Redis密码

   在配置文件中有个参数： requirepass  这个就是配置 Redis 访问密码的参数，需重启 Redis 才能生效）

```shell
 requirepass 密码
```

Redis 的查询速度是非常快的，外部用户一秒内可以尝试多大150K个密码，所以密码要尽量长（对于DBA 没有必要必须记住密码）；

###    2、不重启Redis设置密码

   在配置文件中配置 requirepass 的密码（当 Redis 重启时密码依然有效）

```shell
 redis 127.0.0.1:6379> config set requirepass 密码
```

####    查询密码

```shell
   redis 127.0.0.1:6379> config get requirepass
   (error) ERR operation not permitted
```

####    密码验证

```shell
   redis 127.0.0.1:6379> auth 密码
   OK
```

####    再次查询

```shell
   redis 127.0.0.1:6379> config get requirepass
   1) "requirepass"
   2) "test123"
```

>    PS：如果配置文件中没添加密码 那么 Redis 重启后，密码失效。

###    3、登陆有密码的 Redis：

####    在登录的时候的时候输入密码

```shell
redis-cli -p 6379 -a test123
```

####    先登陆后验证  

```shell
 redis-cli -p 6379
 redis 127.0.0.1:6379> auth test123
 OK
```



> AUTH 命令跟其他redis命令一样，是没有加密的；阻止不了攻击者在网络上窃取你的密码。 
>
> 认证层的目标是提供多一层的保护。如果防火墙或者用来保护redis的系统防御外部攻击失败的话，外部用户如果没有通过密码认证还是无法访问 Redis 的。



参考资料：

https://blog.51cto.com/weipengfei/1217872





**<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**