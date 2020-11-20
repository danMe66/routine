# thrift相关

## 官网说明：

http://thrift.apache.org/

### 将 thrift 文件编译成 php 代码

```shell
thrift --gen php:server xxx.thrift
```

## 将 thrift 文件编译到指定目录

```shell
thrift -o ../lib/com/ciwei/ -out ../lib --gen php:server xxx.thrift
```

