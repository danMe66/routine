package my;

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

		int[] arr5 = { 1, 3, 5, 79, 55 };
		int results = 0;
		for (int i = 0; i < arr5.length; i++) {
			if (arr5[i] > results) {
				results = arr5[i];
			}
		}

		System.out.println("数组arr5的最大元素为：" + results);



		System.out.println("--------------------------------对象的销毁--------------------------------");
		// 只需要创建，不需要销毁，因为Java自己会做垃圾回收
		// GC 垃圾回收机制，回收的不是垃圾，而是不再被使用的对象

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

		System.out.println("-------------------------------- 链表（linkedList） --------------------------------");
		// 链表可以克服容器（数组）的缺点
		// 链表：以“链式形状”串起来的队列
		// 节点：链表里边的每个对象（Node）
		// 链表头：最前边的那个节点

	}
}
