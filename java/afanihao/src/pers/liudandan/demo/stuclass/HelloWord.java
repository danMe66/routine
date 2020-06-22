package pers.liudandan.demo.stuclass;

public class HelloWord {

	public static void main(String[] args) {
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


		System.out.println("--------------------------------Java类的方法调用、返回值--------------------------------");
		Students s3 = new Students();
		// 调用方法（c++里边叫函数，java里边叫方法）
		s3.show(4);
		
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
	}
}
