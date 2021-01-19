# git项目导入其他的git仓库

## 第一步：可能原始的Git项目

```shell
git clone --bare https://git.example.com/your/project.git your_path
```

## 第二步：更改Git提交的仓库地址

```shell
git remote set-url origin https://git.example.com/your/project.git your_path
```

## 第三步：提交到远程仓库

```shell
git push --mirror
```

