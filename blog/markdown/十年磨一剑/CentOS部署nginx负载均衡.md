# CentOS部署nginx负载均衡

利用 nginx 本身的特性配置一下负载均衡，在这里服务器本身是宿主机，用 docker 在宿主机上拉两个nginx容器，相当于服务器2和服务器3。

宿主机上边没有任何业务代码，只搭载了 ngixn 服务，作用只是为了为了进行分发，代码在服务器2（容器1）和服务器3（容器2）上边。

## 前提

一台 CentOS 的服务器，且服务器上安装了 nginx ，docker

关于 CentOS 下安装 Nginx 和 Docker ，在此不进行操作说明，百度即可，文档颇多。

## 定义宿主机

安装好以上所有项目后，我们需要将宿主机下的 Nginx 默认 Html 内容进行修改，标记为宿主机

```
cd /home/wwwroot/
rm -f index.html
```

重新建 index.html

```
echo 我是宿主机 > index.html
```

这样，访问宿主机的 IP就会出现

![image-20200731113347167](https://liudandandear.gitee.io/image/image-20200731113347167.png)

## 使用 Docker 安装容器1

```
docker pull hub.c.163.com/library/nginx:lates
```

查看容器

```
docker images
```

根据镜像 ID 启动容器

容器名：nginx_web1  映射容器8080端口到宿主机的80端口上，并且进入该容器

```
docker run -p 8080:80 --name nginx_web1 -it hub.c.163.com/library/nginx /bin/bash
```

进入容器1的 ngxin 目录

```
cd /usr/share/nginx/html/
```

修改显示的主页面

```
echo 请求到我①号从主机上来啦 > index.html
```

修改完毕退出该容器

```
exit
```

## 使用 Docker 安装容器2

容器名：nginx_web2  映射容器8080端口到宿主机的80端口上，并且进入该容器

```
docker run -p 8081:80 --name nginx_web2 -it hub.c.163.com/library/nginx /bin/bash
```

进入容器1的 ngxin 目录

```
cd /usr/share/nginx/html/
```

修改显示的主页面

```
echo 请求到我②号从主机上来啦 > index.html
```

修改完毕退出该容器

```
exit
```

退出容器后，容器关闭，而且我们修改了容器①和容器②的配置，所以我们要重新启动下

先查询一下容器，根据容器ID重启

```
docker ps -a
```

根据 CONTAINER ID 启动两个容器

```
 docker restart c2de9dbdebb4
 docker restart 14ee73f24ac0
```

启动容器中的 Nginx 服务

```
docker exec -d c2de9dbdebb4  service nginx start 
docker exec -d 14ee73f24ac0  service nginx start 
```

