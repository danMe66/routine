# PHP 控制反转（IOC）和依赖注入（DI）

对于“控制反转（IOC）”和“依赖注入（DI）”两个概念，首先要明白以下概念：

- 控制反转（IOC）是一种思想，依赖注入（DI）是实施这种思想的方法；
- IOC 意味着将你设计好的对象交给容器控制，而不是传统的在对象内部控制；
- 依赖注入（DI）实现了控制反转（IOC）；

# 依赖注入的实现

## 一：接口注入

```php
<?php

/**
 * 定义一个消息接口
 * Interface Message
 */
interface Message
{
    public function send();
}

/**
 * 发送邮件的消息类
 * Class SendEmail
 */
class SendEmail implements Message
{

    public function send()
    {
        echo "email 发送成功！";
    }
}

/**
 * 发送短信的消息类
 * Class SendSms
 */
class SendSms implements Message
{

    public function send()
    {
        echo "sms 发送成功！";
    }
}

/**
 * 模拟购买流程
 * Class Order
 */
class Order
{
    //TODO::下单
    //TODO::购买
    //发送消息

    /**
     * @var String 消息内容
     */
    protected String $message;

    function __construct(Message $message)
    {
        $this->message = $message;
    }

    public function send_msg()
    {
        return $this->message->send();
    }
}

//TODO::比如购买成功了，这里开始发送消息
$message = new SendEmail();//发送邮件
//$message = new SendEmail();//发送短信
$order = new Order($message);
$order->send_msg();
```



## 分析

Order 类依赖消息类的 Message 接口

```php
$order = new Order($message);
```

具体的消息类实例化交给外部处理，不论你是发送短信还是邮件，你自己实例化就好，不要影响我的 Order 类，你只需要把 Message 的接口实现类给我就好

```php
$message = new SendEmail();//发送邮件
//$message = new SendEmail();//发送短信
$order = new Order($message); 
$order->send_msg();
```



### 二：构造器注入

```php
<?php

/**
 * 构造器注入
 * 定义一个有构造函数的类
 * Class IocB
 */
class iocAA
{
    public $b;

    public $c;

    public function __construct($iocB, $iocC)
    {
        $this->b = $iocB;
        $this->c = $iocC;
    }

    public function Method()
    {
        $this->b->Method();
        $this->c->Method();
    }
}

class IocB
{

    public function Method()
    {
        echo '我是 IocB 的 Method 方法';
    }
}

class IocC
{
    public function Method()
    {
        echo '我是 IocC 的 Method 方法';
    }
}
$a = new iocAA(new IocB(), new IocC());
$a->Method();
```



## 分析

进行实例化类的时候，对构造函数的两个参数进行实例化赋值（将实例化后的对象赋值给 iocAA 类 的两个属性）

```php
$a = new iocAA(new IocB(), new IocC());
```

然后调用对象的方法即可

```php
$a->Method();
```



## 三：setter 方法注入

```php
<?php

class IocC
{
    private $db;

    private $file;

    function setDb($db)
    {
        $this->db = $db;
    }

    function setFile($file)
    {
        $this->file = $file;
    }
}

class file
{
    public function __construct()
    {
        echo "file 的 构造函数执行了" . "\n";
    }

    public function run()
    {
        echo "file 的 run" . "\n";
    }
}

class db
{
    public function __construct()
    {
        echo "db 的 构造函数执行了" . "\n";
    }

    public function run()
    {
        echo "db 的 run" . "\n";
    }
}

$iocC = new IocC();
$iocC->setdb(new db());
$iocC->setfile(new file());
```



## 分析

先实例化 IocC 类

```php
$iocC = new IocC();
```

接着调用 IocC 类的方法使用，调用 IocC 的方法 setDb 和 setFile 的时候，需要把实例化的对象当做参数传进去

```php
$iocC->setdb(new db());
$iocC->setfile(new file());
```





​                                                                                                                                                                   **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**