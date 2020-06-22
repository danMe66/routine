package pers.liudandan.demo;

import pers.liudandan.demo.Parent;

public class Child extends Parent {
	public Child()
	{
		super(12);// 如果加参数，会调用父类的有参数的构造，反之，则会调用没有参数的构造
		System.out.println("子类的构造方法输出");
	}
}
