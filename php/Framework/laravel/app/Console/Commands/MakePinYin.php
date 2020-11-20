<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use Overtrue\Pinyin\Pinyin;

class MakePinYin extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'command:pinyin {string}';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'Command description';

    /**
     * Create a new command instance.
     *
     * @return void
     */
    public function __construct()
    {
        parent::__construct();
    }

    /**
     * Execute the console command.
     * 执行命令：php artisan command:pinyin 你好
     * @return mixed
     */
    public function handle()
    {
        $string = $this->argument('string');
        $pinyin = new Pinyin(); // 默认
        $string = $pinyin->permalink($string);
        $this->info($string);
    }
}
