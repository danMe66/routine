package pers.liudandan.demo.polymorphic;

import java.util.Arrays;

public class HelloWord {
	public static void main(String[] args) {
		System.out.println("--------------------------------单根继承--------------------------------");
		// A->B->C->D(A继承B，B继承C，C继承D)
		// 如果一个类没有指定父类，则它默认父类就是Object

		System.err.println("--------------------------------多态(重点)--------------------------------");
		// 多态：重载（overload）方法允许重载
		// 多态：重写（override）允许子类重写父类的方法
		// 泛型：ArrayList

		Pie pie = new ApplePie();
		Baby baby = new Baby();
		baby.eat(pie);
		// 子类转换成 父类顺利成章（隐式转换）
		ApplePie applePie = new ApplePie();
		Pie pie2 = applePie;
		// 父类转换成子类要谨慎（显式转换）
		ApplePie pie3 = (ApplePie) pie2;// 显式转换

		// 多态实现demo
		MyVideoFile myVideoFile2 = new MyVideoFile();
		myVideoFile2.name = "纪录片.mp4";
		myVideoFile2.size = 10000;
		myVideoFile2.duration = 120000;
		// 调用方法的时候看对象的实际类型
		MyFile myFile2 = myVideoFile2;
		myFile2.info();// 调用子类的info
		// 所以的对象都是Object
		Object x = new MyVideoFile();
		
		System.out.println("--------------------------------类的继承--------------------------------");
		// 父类
		MyFile myFile = new MyFile();
		myFile.name = "abc.mp4";
		myFile.size = 1000;
		myFile.info();
		// 子类
		MyVideoFile myVideoFile = new MyVideoFile();
		myVideoFile.name = "父文件";
		myVideoFile.size = 1000;
		myVideoFile.duration = 12000;
		myVideoFile.info();
		myVideoFile.play();
		myVideoFile.stop();
		myVideoFile.duration = 100000;
		// 父类的public属性，方法，在子类中自动继承得到
		
		System.out.println("--------------------------------重写（override）--------------------------------");
		// 重写是针对普通的方法（函数），构造方法不能叫重写
		// 在创建子类对象是，父类的构造方法会被自动调用
		
		int[] arr6 = { 12, 16, 21, 24, 64 };
		MyMatch myMatch = new MyMatch();
		myMatch.getMax(arr6);
		int results1 = myMatch.getMax2(arr6);
		System.out.println("getMax2的返回值为：" + results1);

		// 找出arr6能被8整除的数
		int[] finRes = myMatch.find8(arr6);
		System.out.println("被8整除的数为：" + Arrays.toString(finRes));

		System.out.println("--------------------------------Java类的方法重载（overload）--------------------------------");
		// 调用的时候，编译器会根据参数列表来匹配不同的方法
		myMatch.test();
		myMatch.test(12);
		myMatch.test(12, 13);
	}
}
