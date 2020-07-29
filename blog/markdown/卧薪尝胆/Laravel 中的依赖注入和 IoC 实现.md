# Laravel 中的依赖注入和 IoC 实现

在 Laravel 中，有一个叫“服务容器的东西”，用于管理类的依赖和执行依赖注入的工具。

类的依赖项通过构造函数，或者通过 setter 方法注入到类中。

## 代码

```
<?php

namespace App\Http\Controllers;

use App\User;
use App\Repositories\UserRepository;
use App\Http\Controllers\Controller;

class UserController extends Controller
{
    /**
     * 用户存储库的实现。
     *
     * @var UserRepository
     */
    protected $users;

    /**
     * 创建新的控制器实例。
     *
     * @param  UserRepository  $users
     * @return void
     */
    public function __construct(UserRepository $users)
    {
        $this->users = $users;
    }

    /**
     * 显示指定用户的 profile。
     *
     * @param  int  $id
     * @return Response
     */
    public function show($id)
    {
        $user = $this->users->find($id);

        return view('user.profile', ['user' => $user]);
    }
}
```



## 分析

因为控制器 UserController 需要从数据源中获取 user 对象，所以通过构造器注入的方式注入了 user 的服务，UserRepository 可能是使用 ORM 从数据库获取了 user 信息。

上边这个例子是使用 构造函数的方式进行了依赖注入，当然，也可以使用 ***Setter 方法注入***

```
class UserProvider{
    protected $connection;
    public function __construct(){
        ...
    }

    public function setConnection( Connection $con ){
        $this->connection = $con;
    }
    ...
```

还有 *接口注入*

```
interface ConnectionInjector{
    public function injectConnection( Connection $con );
}

class UserProvider implements ConnectionInjector{
    protected $connection;

    public function __construct(){
        ...
    }

    public function injectConnection( Connection $con ){
        $this->connection = $con;
    }
}
```



在 Laravel 中，先使用 `bind()` 函数进行服务绑定，使用 `make()` 函数进行解析，最后在容器内由 `build()` 函数创建并返回实例。



## 服务容器绑定

在 Larevl 中，几乎所有的服务容器都是在 服务提供者（App\Providers） 中完成的

```
// 第一种绑定：简单绑定
$this->app->bind('HelpSpot\API', function ($app) {
    return new HelpSpot\API($app->make('HttpClient'));
});

// 第二种绑定：绑定一个单例
$this->app->singleton('HelpSpot\API', function ($app) {
    return new HelpSpot\API($app->make('HttpClient'));
});

// 第三种绑定：绑定实例
$api = new HelpSpot\API(new HttpClient);
$this->app->instance('HelpSpot\API', $api);

// 第四种绑定：绑定原始值
$this->app->when('App\Http\Controllers\UserController')
    ->needs('$variableName')
    ->give($value);
```

在服务提供者中，通过 `$this->app` 变量来访问容器，然后使用 `bind` 方法来注册一个绑定，这个方法需要两个参数，第一个参数是需要注册的类名或者接口名称，第二个参数则是返回类的实例的闭包。



## 参考文章：

https://xueyuanjun.com/post/9534