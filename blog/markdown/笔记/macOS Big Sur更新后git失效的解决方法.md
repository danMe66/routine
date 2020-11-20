# macOS Big Sur更新后git失效的解决方法

### 具体表现为，系统更新后，输入任何git相关的命令，均会有以下错误提示：

```shell
xcrun: error: invalid active developer path (/Library/Developer/CommandLineTools), missing xcrun at: /Library/Developer/CommandLineTools/usr/bin/xcrun
```

看起来像是CommandLineTools的路径出现问题，git找不到依赖。虽然重新安装CommandLineTools也能解决问题，CommandLineTools正常来说是已经随系统（Xcode）安装好了，所以可以通过以下命令对xcode-select进行重置，即可解决问题：

```shell
sudo xcode-select --reset
```











​                                                                                                                                                                   **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**

