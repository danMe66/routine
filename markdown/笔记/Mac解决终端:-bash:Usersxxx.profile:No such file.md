# Mac 解决终端：-bash: /Users/xxx/.profile: No such file or directory

##### 打开Mac终端控制台出现：-bash: /Users/xxx/.profile: No such file or directory 的问题如图：

![](https://cdn.phpmianshi.cn/PicGo/20201027160621.png)

原因是环境变量出现了问题，使用命令打开编辑.bash_profile：

```shell
vim ~/.bash_profile
或者
open ~/.bash_profile
```

![](https://cdn.phpmianshi.cn/PicGo/20201027160654.png)

将source ~/.profile 删除，然后在第一行编辑加入：

```ruby
export PATH=/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin
```

这是系统默认初始环境变量，直接复制粘贴就行
 最后退出保存，重新打开终端问题解决。

