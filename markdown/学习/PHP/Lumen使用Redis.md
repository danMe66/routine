# Lumen使用Redis



##  安装扩展

```php
 composer require predis/predis
 composer require illuminate/redis
```



## 引入redis支持

在目录`bootstrap/app.php`中要引入redis的扩展

```php
$app->register(Illuminate\Redis\RedisServiceProvider::class);
```



## 启动辅助函数

> Lumen和Laravel有些不一样，默认’Facades’和’Eloquent’是没有启用的，要想像laravel中使用redis一样，要把文件`bootstrap/app.php`里的 `Facades` 和 `Eloquent` 的`$app->withFacades()` 和 `$app->withEloquent()`注释打开就好了



## 配置redis服务器参数

> 默认系统是调用的`.env`里的redis配置文件，但是一般安装后没有这些参数，可以查看文件路径`vendor/laravel/lumen-framework/config/database.php`中查看有哪些参数需要配置，例如，我的`.env`文件需要配置

```php
REDIS_HOST=127.0.0.1
REDIS_PORT=6379
REDIS_PASSWORD=
```



## 使用Redis

首先要在使用redis的控制器内引入类

```php
use Illuminate\Support\Facades\Redis
```

然后直接使用

```php
Redis::setex('site_name', 10, 'Lumen的redis');
return Redis::get('site_name');
```













**<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**