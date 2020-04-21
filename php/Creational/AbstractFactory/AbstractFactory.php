<?php

namespace AbstractFactory;

/**
 * 抽象工厂类
 * 该设计模式实现了设计模式的依赖倒置原则，因为最终由具体子类创建具体组件
 * 在这个抽象工厂类中定义 造车 组件 【创建车轮】和 【创建外壳】
 *
 * Class AbstractFactory
 */
abstract class AbstractFactory
{
    /**
     * 创建车轮
     * @param string $rubber 橡胶
     * @return mixed
     */
    abstract public function createWheel($rubber);

    /**
     * 创建外壳
     * @param string $iron 铁
     * @return mixed
     */
    abstract public function createShell($iron);
}