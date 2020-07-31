# PHP-FPM 是什么？

**PHP-FPM** 即 PHP FastCGI的进程管理器。

**CGI** 的意思是 ==通用网关接口== ，是 Web 服务器调用外部程序时使用的一种服务端应用的规范。

**CGI** 针对每个 HTTP 请求都会 fork 一个新的进程来进行处理（解析配置文件、初始化执行环境、处理请求），然后把这个进程处理完的结果通过 Web 服务转发给用户，刚刚 fork 的新进程也随之退出，如果下次用户再请求动态资源，Web 服务器又再次 fork 一个新的进程，如此周而复始循环往复。

**Fast****CGI** 是 CGI 的升级版本，为提升 CGI 的性能而生。FastCGI 会先 fork 一个新的 master 进程，解析配置文件，初始化执行环境，然后再 fork 多个 worker 进程（类似于 nginx），当 HTTP 请求过来时，master 会将请求传递给一个 worker 进程，然后再接收下一个请求，这样的话只需要解析一次配置文件，初始化一次执行环境，每次请求不会阻塞，导不会致请求停滞。这样大大提高了请求效率，可以处理高并发环境下的业务场景。Master 还会更根据配置预先启动几个 Worker 进程进行等待，当Worker 进程过多，Master 也会根据配置文件设置销毁掉多余的 Worker，这样提高了性能，也节约了系统资源。

**PHP-FPM** 负责管理一个进程池来处理来自 Web 服务器的 HTTP 动态请求，在PHP-FPM 中，Master 进程负责与 Web 服务器进行通信，接收 HTTP 请求，再将请求转发给 worker 进程处理。Worker 进程主要负责动态执行 PHP 代码，处理完成后，将处理结果返回给 Web 服务器，再由 Web 服务器将结果发送给客户端，这就是 PHP-FPM 的工作原理。



## 资料：

https://www.php.net/manual/zh/install.fpm.php

https://www.jianshu.com/p/6b8511e0bd88

https://zhuanlan.zhihu.com/p/110540192





​                                                                                                                                                                   **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**