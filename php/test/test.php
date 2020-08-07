<?php
class my_class {

    var $my_value = [];
    function my_class ($value){
        $this->my_value[] = $value;
    }
    function set_value ($value){
        $this->my_value = $value;
    }

}

$a = new my_class('a');
$a -> my_vulue[] = 'b';
$a -> set_value('c');
$a -> my_class('d');
var_dump($a->my_value);