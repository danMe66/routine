package pers.liudandan.demo;

import java.util.Arrays;

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
		arr3[0] = 12;// 此处会造成空指针错误
		System.out.println("arr3 的新值为：" + Arrays.toString(arr3));

		System.out.println("--------------------------------Java的类和属性--------------------------------");
		Students students = new Students();
		students.name = "小马";
		students.age = 18;
		students.sex = true;

		students.studenCards.schooleNumber = 001;
		students.studenCards.schooleName = "二中";
	}
}
