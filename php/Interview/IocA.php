<?php

/**
 * 接口注入的方式
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