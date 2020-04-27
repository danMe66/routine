<?php

namespace AbstractFactory\Impl;

use AbstractFactory\AbstractFactory;

/**
 * 比亚迪零部件制造代理商
 * Class BydImpl
 */
class BydImpl extends AbstractFactory
{

    /**
     * 创建车轮
     * @inheritDoc
     */
    public function createWheel($rubber)
    {
        return '比亚迪车轮' . $rubber;
    }

    /**
     * 创建外壳
     * @inheritDoc
     */
    public function createShell($iron)
    {
        return '比亚迪外壳' . $iron;
    }
}