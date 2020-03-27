<?php

use Faker\Generator as Faker;

//$factory->define(\App\Models\Courses::class, function (Faker $faker) {
//    return [
//        'name' => $faker->title,
//        'sex' => array_rand([0, 1]),
//        'age' => array_rand([18, 15, 23, 44, 23, 12, 9]),
//    ];
//});

$factory->define(\App\Models\Score::class, function (Faker $faker) {
    $courses_ids = \App\Models\Courses::all()->pluck('id')->toArray();
    $stu_ids = \App\Models\Student::all()->pluck('id')->toArray();

    return [
        'courses_id' => $faker->randomElement($courses_ids),
        'students_id' => $faker->randomElement($stu_ids),
        'score' => $faker->numberBetween(),
    ];
});
//TODO:laravel中faker的方法总结
//TODO:https://www.cnblogs.com/hjcan/p/11551216.html