<?php
//创建内存表
$table = new swoole_table(1024);

//内存表增加一列
$table->column('id', $table::TYPE_INT, 4);
$table->column('name', $table::TYPE_STRING, 64);
$table->column('age', $table::TYPE_INT, 3);
$table->create();

//新增内容
$table->set('demoTable', [
    'id' => 1,
    'name' => 'demoMonth',
    'age' => 30,
]);
//另外一种方案
$table['demoTable2'] = [
    'id' => 2,
    'name' => 'demo2',
    'age' => 31,
];

$table->incr('demoTable2', 'age', 2);//原子自增
$table->decr('demoTable2', 'age', 2);//原子自减

$table->del('demoTable2');//删除指定key

print_r($table->get('demoTable2'));
//print_r($table['demoTable2 ']);