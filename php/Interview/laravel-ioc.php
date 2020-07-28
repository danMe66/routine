<?php

//设计公共接口
interface Go_To_School
{
    public function go();
}

//实现交通工具类
class Foot implements Go_To_School
{
    public function go()
    {
        echo 'walt to school';
    }
}

class Car implements Go_To_School
{
    public function go()
    {
        echo 'drive to school';
    }
}

class Bicycle implements Go_To_School
{
    public function go()
    {
        echo 'ride to school;';
    }
}
//设计学生类，实现去学校时要依赖的交通工具实例

class Student
{
    private $trafficTool;
    public function __construct(Go_To_School $trafficTool)
    {
        $this->trafficTool = $trafficTool;
    }
    public function go_to_school(){
        $this->trafficTool->go();
    }
}


class Container {

    //用于装提供实例的回调函数，真正的容器还会装实例等其他内容
    //从而实现单例等高级功能
    public $bindings = [];

    //绑定接口和生成相应实例的回调函数
    public function bind($abstract, $concrete=null, $shared=false) {

        //如果提供的参数不是回调函数，则产生默认的回调函数 即concrete变为回调函数，不是一个字符串
        if(!$concrete instanceof Closure) {
            $concrete = $this->getClosure($abstract, $concrete);

        }


        $this->bindings[$abstract] = compact('concrete', 'shared');

    }

    //默认生成实例的回调函数
    protected function getClosure($abstract, $concrete) {
        //使用bing函数的时候不执行该函数；仅仅把$abstract, $concrete 放入$container对象中；
        return function($container) use ($abstract, $concrete) {

            $method = ($abstract == $concrete) ? 'build' : 'make';
            echo "回调函数".$abstract;
            var_dump( $concrete);
            //利用回调函数来实例化
            return $container->$method($concrete);
        };


    }
    //解决接口和要实例化类之间的依赖关系
    public function make($abstract) {

        $concrete = $this->getConcrete($abstract);
        echo "make<br>";
        var_dump($concrete);
        if($this->isBuildable($concrete, $abstract)) {
            echo "build<br>";
            $object = $this->build($concrete);
        } else {
            echo "make2<br>";
            $object = $this->make($concrete);
        }
        echo "make end";
        return $object;
    }

    protected function isBuildable($concrete, $abstract) {
        return $concrete === $abstract || $concrete instanceof Closure;
    }

    //获取绑定的回调函数
    protected function getConcrete($abstract) {
        var_dump($this->bindings);echo $abstract;
        //如果是接口或者别名（Go_To_School，studentaaaa）返回回调函数来执行；如果是实例类，则返回实例类字符串
        if(!isset($this->bindings[$abstract])) {
            echo "stringabstract";
            return $abstract;
        }

        return $this->bindings[$abstract]['concrete'];
    }

    //实例化对象
    public function build($concrete) {

        if($concrete instanceof Closure) {
            echo "instanceof";
            //执行回调函数
            return $concrete($this);
        }
        echo "build detail<br>";
        $reflector = new ReflectionClass($concrete);
        //检查类是否可实例化
        if(!$reflector->isInstantiable()) {
            echo $message = "Target [$concrete] is not instantiable";
        }
        // 获取类的构造函数
        $constructor = $reflector->getConstructor();
        if(is_null($constructor)) {
            return new $concrete;
        }

        $dependencies = $constructor->getParameters();
        //public 'name' => string 'trafficTool'

        $instances = $this->getDependencies($dependencies);
        var_dump($reflector->newInstanceArgs($instances));
        //object(Student)[7]private 'trafficTool' => object(Bicycle)[9]
        return $reflector->newInstanceArgs($instances);
    }

    //解决通过反射机制实例化对象时的依赖
    protected function getDependencies($parameters) {

        $dependencies = [];
        foreach($parameters as $parameter) {
            // public 'name' => string 'Go_To_School'
            $dependency = $parameter->getClass();

            if(is_null($dependency)) {
                $dependencies[] = NULL;
            } else {
                $dependencies[] = $this->resolveClass($parameter);
            }
        }

        return (array)$dependencies;
    }

    protected function resolveClass(ReflectionParameter $parameter) {
        var_dump($parameter->getClass()->name);
        //Go_To_School
        return $this->make($parameter->getClass()->name);
    }

}

//实例化IOC容器
$ioc = new Container();

//填充容器
$ioc->bind('Go_To_School', 'Bicycle');  //第一个参数'Go_To_School'是接口，
//第二个参数'Car'是交通工具类

$ioc->bind('studentaaaa', 'Student');    //第一个参数'student'可以理解为服务别名，用make()
//实例化的时候直接使用别名即可，第二个参数'Student'是学生类

//通过容器实现依赖注入，完成类的实例化
//执行回调函数
$student = $ioc->make('studentaaaa');
$student->go_to_school();