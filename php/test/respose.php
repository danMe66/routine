<?php
echo "<pre>";
//header("HTTP/1.1 200 OK");

//header("HTTP/1.1 302 Found");//临时重定向
//header("HTTP/1.1 301 Move Permanently");
//header("Location:https://www.baidu.com");

//基本认证
header("WWW-Authenticate: Basic");

echo "hello";
