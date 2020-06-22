package pers.liudandan.abstractclass;

/**
 * 抽象类
 * 
 * @author mini
 *
 */
public abstract class MyExample {

	// 抽象方法，抽象方法没有方法体
	public abstract void doSomething();

	public static void main(String[] args) {
		// 第一种交通工具：能跑的汽车
		Car car = new Car();
		car.run();

		// 第二种交通工具：能飞的飞机
		Plane plane = new Plane();
		plane.fly();

		// 第三种交通工具：能跑又能飞的汽车
		RootDo rootDo = new RootDo();
		rootDo.run();
		rootDo.fly();

	}

}
