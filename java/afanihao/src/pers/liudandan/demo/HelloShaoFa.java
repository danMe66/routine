package pers.liudandan.demo;

import java.util.Arrays;
import java.util.Random;

public class HelloShaoFa {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = arr1;
		arr2[2] = 11;
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("arr1的元素分别为：" + arr1[i]);
		}
		System.out.println("--------------------------------分隔符--------------------------------");

		int[] arr3 = { 1, 2, 3 };// object1：object重新赋值了，所以object1失去引用，会被java自动回收（删除）
		arr3 = new int[4];// object2
		arr3[0] = arr3[1] = arr3[2] = arr3[3] = 8;
		int[] arr4 = arr3;
		arr3 = null;
//		arr3[0] = 12;// 此处会造成空指针错误
		System.out.println("arr3 的新值为：" + Arrays.toString(arr3));

		System.out.println("--------------------------------Java的类和属性--------------------------------");
		Students students = new Students();
		students.name = "小马";
		students.age = 18;
		students.sex = true;

		Students s1 = new Students();
		Students s2 = s1;
		s2.name = "hello";// 此处修改了s2的name值，那么s2的name属性值也会是修改之后的值，因为他们是同一个对象

		students.studenCards.schooleNumber = 1;
		students.studenCards.schooleName = "二中";

		System.out.println("--------------------------------Java类的方法调用、返回值--------------------------------");
		Students s3 = new Students();
		// 调用方法（c++里边叫函数，java里边叫方法）
		s3.show(4);

		int[] arr5 = { 1, 3, 5, 79, 55 };
		int results = 0;
		for (int i = 0; i < arr5.length; i++) {
			if (arr5[i] > results) {
				results = arr5[i];
			}
		}

		System.out.println("数组arr5的最大元素为：" + results);

		MyMatch myMatch = new MyMatch();
		myMatch.getMax(arr5);
		int results1 = myMatch.getMax2(arr5);
		System.out.println("getMax2的返回值为：" + results1);

		// 找出能被8整除的数
		int[] arr6 = { 12, 16, 21, 24, 64 };
		int[] finRes = myMatch.find8(arr6);
		System.out.println("被8整除的数为：" + Arrays.toString(finRes));

		System.out.println("--------------------------------Java类的方法重载（overload）--------------------------------");
		// 调用的时候，编译器会根据参数列表来匹配不同的方法
		myMatch.test();
		myMatch.test(12);
		myMatch.test(12, 13);

		System.out.println("--------------------------------Java类对象--------------------------------");

		Screen screen = new Screen();
		screen.width = 12;
		screen.heigth = 3;
		int p = screen.pixel(screen.width, screen.heigth);
		System.out.println("第一种求像素的方法，结果为：" + p);

		int p1 = screen.pixel1(screen);
		System.out.println("第二种求像素的方法，结果为：" + p1);

		int p2 = screen.pixel2();
		System.out.println("第三种求像素的方法，结果为：" + p2);

		Example example = new Example();
		example.show();
		example.show1();

		System.out.println("--------------------------------demo1--------------------------------");
		int a = 10;
		int b = 20;
		int c = 50;
		example.insertCash(a);// 第一次充值
		example.insertCash(b);// 第二次充值
		example.insertCash(c);// 第三次充值
		System.out.println("充值完成，提取游戏币");
		example.exchange();
		System.out.println("--------------------------------demo2--------------------------------");
		// 笔记：对象=属性+方法
		// 属性：就是数据
		// 方法：就是算法
		// 对象就数据和算法的一个整合体
		// 给它所需的数据-》让他干活-》取出结果
		System.out.println("--------------------------------读取私有属性--------------------------------");
		Exampler exampler = new Exampler();
		exampler.setNumber(12);
		System.out.println("结果为:" + exampler.getNumber());
		System.out.println("--------------------------------类的构造方法--------------------------------");
		GouZao gouZao = new GouZao("小明", 18, true);
		System.out.println("输出:name" + gouZao.name + " age:" + gouZao.age + " sex:" + gouZao.sex);
		// 构造方法在创建时被调用
		// 构造方法是常用方法，一般的类都应该加一个构造方法

		System.out.println("--------------------------------对象的销毁--------------------------------");
		// 只需要创建，不需要销毁，因为Java自己会做垃圾回收
		// GC 垃圾回收机制，回收的不是垃圾，而是不再被使用的对象

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

		System.out.println("--------------------------------构造方法的继承--------------------------------");

		Child child = new Child();
		System.out.println("EXIT");

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

		System.err.println("-------------------------------- 关于 toString --------------------------------");
		Students students2 = new Students();
		students2.name = "小马";
		students2.age = 18;
		students2.sex = false;
		String info = students2.toString();
		System.out.println("学生信息：" + info);
		// 如果一个类没有重写toString(),则使用Object的默认实现
		// 如果类中没有toString()方法，Objetct.toString()默认格式为【类名@对象地址】
		// toString()的作用：将一个对象转化成字符串。在字符串拼接时、单步调试观察时，会被自动调用。

		System.err.println("-------------------------------- 静态方法（全局方法） --------------------------------");
		// 静态方法不能访问当前对象，也就不能使用this
		// 静态方法不用new就能直接访问【类名.方法】
		// Java内置的数学计算类 Match
		// abs(a):求a的绝对值
		// pow(a,b):求a的b次幂
		// sqrt(a):求a的平方根
		// round(a):四舍五入
		// sin/cos/tan：正弦/余弦/正切
		System.out.println("-123的绝对值为：" + Math.abs(-123));
		System.out.println("2的3次幂为：" + Math.pow(2, 3));
		System.out.println("3 * 3 + 4 * 4(直角三角形)的平方根为：" + Math.sqrt(3 * 3 + 4 * 4));

		System.err.println("-------------------------------- 字符串判断 --------------------------------");
		String ss1 = new String("hello");
		String ss2 = new String("hello");
		String ss3 = new String("Hello");

		// 输出：相同
		if (ss1.equals(ss2)) {
			System.out.println("相同");
		} else {
			System.out.println("不相同");
		}
		// 输出：不相同
		if (ss1.equals(ss3)) {
			System.out.println("相同");
		} else {
			System.out.println("不相同");
		}
		// 输出：不相同
		if (ss1 == ss2) {
			System.out.println("相同");
		} else {
			System.out.println("不相同");
		}

		// 字典排序
		String ss4 = "lilei";
		String ss5 = "liming";
		if (ss4.compareTo(ss5) < 0) {
			System.out.println("ss4（lilei）在前边");
		} else {
			System.out.println("ss5（liming）在前边");
		}

		// 忽略大小写的比较：compoareToIgnoreCase()

		// 格式化符
		String asd = String.format("姓名：%s" + " 年龄:%d" + " 身高：%.2f", "小马", 18, 1.75);
		System.out.println(asd);

		// 查找indexOf
		// a.indexOf("string") 如果有这个子串，则返回位置索引；否则返回-1

		// 前缀后缀
		// startsWith():判断前缀
		// endsWith():判断后缀

		String fileName = "abs.mp4";
		if (fileName.endsWith("mp4")) {
			System.err.println("不支持此文件格式");
		} else {
			System.out.println("文件类型验证通过");
		}

		System.err.println("-------------------------------- 包装类 --------------------------------");
		//

		System.err.println("-------------------------------- 控制台程序 --------------------------------");
		Console console = new Console();
		console.print("请输入用户名：");
		// ~~~~不需要学习

		System.err.println("-------------------------------- 随机数 --------------------------------");
		// 使用Random类生成随机数
		Random random = new Random();
		// 生成一个0~1000的随机数
		int sss = random.nextInt(1000);

		System.out.println("生成一个0~1000的随机数:" + sss);
		for (int i = 0; i < 10; i++) {
			System.out.println("循环生成一个0~1000的随机数:" + random.nextInt(1000));
		}

		System.err.println("-------------------------------- 字符 --------------------------------");
		// 用单引号表示一个字符
		// 每个字符都对应一个数字

//		System.out.println("-------------------------------- 容器 --------------------------------");
//		// 数组就是一个容器
//		Students[] ss = new Students[4];
//		ss[0] = new Students("小马", 18, true);
//		ss[1] = new Students("小马1", 19, true);
//		ss[2] = new Students("小马2", 20, true);
//		ss[3] = null;

		// 数据容器的缺点
		// 1：容器固定：无法扩展，既不能设太大，又不能设太小，很难确定
		// 2：插入和删除困难：在插入一个对象的代价很大，需要挪动现有的对象位置

		System.out.println("-------------------------------- 链表（linkedList） --------------------------------");
		// 链表可以克服容器（数组）的缺点
		// 链表：以“链式形状”串起来的队列
		// 节点：链表里边的每个对象（Node）
		// 链表头：最前边的那个节点

		Monkey m1 = new Monkey(101, "圆圆1");
		Monkey m2 = new Monkey(102, "圆圆2");
		Monkey m3 = new Monkey(103, "圆圆3");
		Monkey m4 = new Monkey(104, "圆圆4");
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = null;

		Monkey node = m1;

		Monkey m5 = new Monkey(105, "圆圆5");

		// 加一个节点到尾结点
		// 第一种
//		m4.next = m5;

		// 第二种
//		Monkey m = m1;
//		while (m != null) {
//			if (m.next == null) {
//				break;
//			}
//			m = m.next;
//		}
//		m.next = m5;

		// 加一个节点到第二个节点
		// 第一种：
//		Monkey heade = m1;
//		m5.next = m1.next;
//		m1.next = m5;
		// 第二种：
		while (node != null) {
			if (node.id == 102) {
				m5.next = node.next;
				node.next = m5;
				break;
			}
			node = node.next;
		}

		while (node != null) {
			System.out.println("链表中的对象为：" + node);
			node = node.next;
		}
		System.out.println("EXIT");
		// 链表：是一种组织数据的方式
		// 把若干对象串起来，就构造了一个链表
		// 有了第一个节点，就可以遍历出链表里边所有的节点

	}
}
