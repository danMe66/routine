# Git强制拉取覆盖本地

## 多条执行

```shell
git fetch --all  
git reset --hard origin/master 
git pull
```

## 单条执行

```shell
git fetch --all && git reset --hard origin/master && git pull
```