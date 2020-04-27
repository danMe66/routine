<?php

namespace AbstractFactory\plugs;

use AbstractFactory\base\Wheel as BaseWheel;

class Wheel extends BaseWheel
{
    /**
     * @inheritDoc
     */
    public function Assemble()
    {
        return [
            'name' => $this->name,
            'size' => $this->size,
            'weight' => $this->weight,
        ];
    }
}