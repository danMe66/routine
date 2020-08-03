<?php
echo "<pre>";
//var_dump($_SERVER);
//var_dump($_GET);

//var_dump($_POST);
//var_dump($_POST['name']);
//var_dump($_POST['password']);
//print_r("用户名:".$_POST['name']."密码:".$_POST['password']);
$name=$_REQUEST['name'];
$password=$_REQUEST['password'];
$url=$_REQUEST['url'];
echo "获取链接的URL:".$url."\n";
print_r("name:".$name.",password:".$password);
