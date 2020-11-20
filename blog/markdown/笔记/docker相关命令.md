# Docker相关命令

查看 docker 的所有命令

```shell
docker
```

更深入查看 docker 命令的使用方法和作用

```shell
docker command --help
```

获取镜像（载入 ubuntu 镜像）

```shell
docker pull ubuntu
```

使用 ubuntu 镜像启动容器，并且参数以命令模式进入该容器

```shell
docker run it ubuntu /bin/bash
```

参数说明：

- -i：交互时操作
- -t：终端
- ubuntu：ubuntu 镜像
- /bin/bash：放在镜像后边是命令，交互式的 shell

进入容器后，退出容器

```shell
exit
```

查看所有容器

```shell
docker ps -a
```

查看正在运行的容器

```shell
docker ps
```

启动一个停止的容器

```shell
docker start 容器id
```

后台运行 docker 容器

```shell
docker run -itd -name 容器自定义名字 镜像名称 /bin/bsah
```

停止一个容器

```shell
docker stop 容器id
```

重启一个容器

```shell
docker restart 容器id
```

进入一个容器

```shell
docker attach 容器id
```

退出容器（推荐使用 `docker exec` ，因为这个命令退出容器，不会导致容器停止）

```shell
docker exex
docker exec -it 容器id /bin/bash
```

导出容器

```shell
docker export 容器id > 名称.tar
```

导入容器快照

以使用 docker import 从容器快照文件中再导入为镜像，以下实例将快照文件 ubuntu.tar 导入到镜像 test/ubuntu:v1:

```shell
cat docker/名称.tar | docker import - test/ubuntu:v1
```

通过指定 URL 或者 目录导入

```shell
docker import http://example.com/exampleimage.tgz example/imagerepo
```

删除容器

```shell
docker rm -f 容器id
```

强制删除无法删除的容器

```shell
docker rmi -f 容器id
```



参考文章：

- https://www.runoob.com/docker/docker-container-usage.html





​                                                                                                                                                                   **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**

