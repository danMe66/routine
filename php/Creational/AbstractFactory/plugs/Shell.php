<?php

namespace AbstractFactory\plugs;

use AbstractFactory\base\Shell as BaseShell;

class Shell extends BaseShell
{

    /**
     * @inheritDoc
     */
    public function Assemble()
    {
        return array(
            'name' => $this->name,
            'color' => $this->color,
        );
    }
}