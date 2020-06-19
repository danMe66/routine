package pers.liudandan.demo;

import java.util.Arrays;

public class HelloShaoFa {

	public static void main(String[] args)
	{
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = arr1;
		arr2[2] = 11;
		for (int i = 0; i < arr2.length; i++)
		{
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
		for (int i = 0; i < arr5.length; i++)
		{
			if (arr5[i] > results)
			{
				results = arr5[i];
			}
		}

		System.out.println("数组arr5的最大元素为：" + results);

		MyMatch myMatch = new MyMatch();
		myMatch.getMax(arr5);
		int results1 = myMatch.getMax2(arr5);
		System.out.println("getMax2的返回值为：" + results1);
	}
}
