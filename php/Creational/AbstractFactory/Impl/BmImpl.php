<?php

namespace AbstractFactory\Impl;

use AbstractFactory\AbstractFactory;

/**
 * 宝马零部件制造代理商
 * Class BmImpl
 */
class BmImpl extends AbstractFactory
{

    /**
     * 创建车轮
     * @inheritDoc
     */
    public function createWheel($rubber)
    {
        return '宝马车轮' . $rubber;
    }

    /**
     * 创建外壳
     * @inheritDoc
     */
    public function createShell($iron)
    {
        return '宝马外壳' . $iron;
    }
}