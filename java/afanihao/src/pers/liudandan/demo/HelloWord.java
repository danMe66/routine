package pers.liudandan.demo;

import java.util.Arrays;

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

		// 简单算法：从1加到100
		int total = 0;
		int end = 100;
		for (int k = 1; k <= end; k++)
		{
			total += k;
		}

		// 直接计算
		total = (1 + end) * end / 2;

		System.out.println(total);

		// java 定义数组
		int[] arr = new int[3];
		// 获取数组长度
		System.out.println("数组的长度为：" + arr.length);
		// 访问数组元素
		int element1 = arr[0];
		System.out.println("数组的第一个元素为:" + element1);
		// 重新定义数组元素
		arr[1] = 123;
		arr[2] = 345;
		// 遍历数组
		for (int k = 0; k < arr.length; k++)
		{
			System.out.println("重新定义元素之后的数组元素- " + k + "为：" + arr[k]);
		}
		// 创建数组的同时为数组赋值
		int[] arr2 = new int[] { 20, 56, 78 };
		System.out.println("arr2 的长度为：" + arr2.length);

		// 解决数组长度不可变的问题
		// 因为数组在定义的时候已经给定了长度，所以如果有新的元素加入，数组的本身已经放不下了
		// 这时候就需要重新将原数组的元素拿出来重新定义数组，将旧元素和新元素重新赋值给新的数组
		// 然后再把旧数组指向新数组即可，这样就解决了新元素插入数组的问题

		int[] arr3 = new int[] { 20, 30, 40 };
		// java 数组转字符串 【Arrays.toString(array)】
		System.out.println("arr3 的值为：" + Arrays.toString(arr3));

		// 要加入的数组元素
		int dst = 4;
		// 第一步：定义一个数组，长度是旧数组的+1
		int[] newArr = new int[arr3.length + 1];
		// 第二步：把旧数组中的元素挨个赋值给新
		for (int k = 0; k < arr3.length; k++)
		{
			newArr[k] = arr3[k];
		}
		// 第三步：把目标元素放入新数组的最后一位
		newArr[arr3.length] = dst;
		// 第四步：用新数组替换旧数组
		arr3 = newArr;
		System.out.println("arr3 的新值为：" + Arrays.toString(arr3));

		// 删除数组元素
		// 确定要删除元素的下标
		int node_dst = 2;

		// 创建一个新数组，长度是原数组的-1
		int[] arr4 = new int[arr3.length - 1];
		// 复制原数组除了那个要删除的元素以外其他的元素
		for (int k = 0; k < arr4.length; k++)
		{
			// 删除元素之前的元素
			if (k < node_dst)
			{
				arr4[k] = arr3[k];
			}
			// 要删除元素之后的元素
			else
			{
				arr4[k] = arr3[k + 1];
			}
		}
		// 新数组替换旧数组
		arr3 = arr4;
		System.out.println("删除数组 arr3 的第二个元素之后的数组为：" + Arrays.toString(arr3)); 

		// 模运算
		double ab = 14;
		double ac = 5;
		System.out.println("14÷5为：" + ab / ac);
		System.out.println("14÷5的取余为：" + ab % ac);
		System.out.println("14÷5的取模为：" + Math.floorMod(14, 5));

		int counts = 0;
		for (int k = 0; k <= 100; k++)
		{
			counts += k * k;
		}

		System.err.println("1-100的平方和：" + counts);

		for (int k = 0; k < 100; k++)
		{
			if (k % 3 == 0)
			{
				System.err.println("能被3整除的值为：" + k);
			}
		}
		System.out.println("--------------------------------分隔符--------------------------------");

	}
}
