package pers.liudandan.demo;

public class HelloWord {

	public static void main(String[] args)
	{
		System.out.println("Hello,Welcome to Java World!");

		// 字符串
		String name = "dawson_liu";
		System.out.println("Hello,我是" + name);

		// 整数
		int a = 12345;
		int b = -2345;
		System.out.println("a=" + a + ",b=" + b);

		// 小数
		double c = 123.456;// 输出123.45
		double d = -349;// 输出-349.0
		System.out.println("c=" + c + ",d=" + d);

		// 变量赋值
		int e = 0;
		System.out.println("e的初始值" + e);
		int f = 5;
		// TODO::等号代表赋值
		e = f * f;
		System.out.println("e被赋值之后的值" + e);

		// 布尔变量
		Boolean g = true;
		Boolean h = false;
		System.out.println("g=" + g + ",h=" + h);
		int i = 1;
		int j = 0;
		System.out.println("i=" + i + ",j=" + j);
	}
}
