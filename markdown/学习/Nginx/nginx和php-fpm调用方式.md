

# nginx和php-fpm调用方式

## nginx 是什么？

nginx 是一个高性能的 HTTP 和反向代理服务器，也是一个 IMAP/POP3/SMTP 服务器。

php-fpm 是什么？

[《PHP-FPM 是什么？》](https://www.yuque.com/docs/share/ccf6de87-098c-4e78-a09a-79613d3cc9f1?#)

要明白 nginx 和 php-fpm 是怎么结合的，首先要清楚之间是怎么配置在一起的，主要有三处：

## **第一处：虚拟机 server 的配置**

```shell
server {
    listen       80; #监听80端口，接收http请求
    server_name  www.example.com; #就是网站地址
    root /usr/local/etc/nginx/www/huxintong_admin; # 准备存放代码工程的路径
    #路由到网站根目录www.example.com时候的处理
    location / {
        index index.php; #跳转到www.example.com/index.php
        autoindex on;
    }   

    #当请求网站下php文件的时候，反向代理到php-fpm
    location ~ \.php$ {
        include  fastcgi_params; #加载nginx的fastcgi模块
        fastcgi_pass   127.0.0.1:9000; #nginx fastcgi进程监听的IP地址和端口
    }

}
```



## **第二处：fastcgi.conf 的配置，这个配置主要是把 nginx 中的变量，解释为 PHP 能够理解的变量：**

```shell
fastcgi_param  SCRIPT_FILENAME    $document_root$fastcgi_script_name;
fastcgi_param  QUERY_STRING       $query_string;
fastcgi_param  REQUEST_METHOD     $request_method;
fastcgi_param  CONTENT_TYPE       $content_type;
fastcgi_param  CONTENT_LENGTH     $content_length;

fastcgi_param  SCRIPT_NAME        $fastcgi_script_name;
fastcgi_param  REQUEST_URI        $request_uri;
fastcgi_param  DOCUMENT_URI       $document_uri;
fastcgi_param  DOCUMENT_ROOT      $document_root;
fastcgi_param  SERVER_PROTOCOL    $server_protocol;
fastcgi_param  HTTPS              $https if_not_empty;

fastcgi_param  GATEWAY_INTERFACE  CGI/1.1;
fastcgi_param  SERVER_SOFTWARE    nginx/$nginx_version;

fastcgi_param  REMOTE_ADDR        $remote_addr;
fastcgi_param  REMOTE_PORT        $remote_port;
fastcgi_param  SERVER_ADDR        $server_addr;
fastcgi_param  SERVER_PORT        $server_port;
fastcgi_param  SERVER_NAME        $server_name;

# PHP only, required if PHP was built with --enable-force-cgi-redirect
fastcgi_param  REDIRECT_STATUS    200;
```



## **第三处：php-fpm.conf 配置**

```shell
listen = 127.0.0.1:9000
```



## 总结：

nginx 是通过 fastcgi_pass 指令调用 php-fpm 的监听端口。



## 完整流程图如下：

![img](https://cdn.nlark.com/yuque/0/2020/svg/282255/1595410597804-a74a7b6a-c474-4512-9a03-4c51a529dfff.svg)



## 资料：

https://www.cnblogs.com/luoahong/articles/9139888.html

https://www.jianshu.com/p/aff916a26940

https://zhuanlan.zhihu.com/p/111508553





​                                                                                                                                                                   **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**