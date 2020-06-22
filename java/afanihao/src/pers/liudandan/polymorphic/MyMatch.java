package pers.liudandan.polymorphic;

public class MyMatch {

	public void getMax(int[] data) {
		int results = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > results) {
				results = data[i];
			}
		}
		System.out.println("数组的最大元素为：" + results);
	}

	public int getMax2(int[] data) {
		int results = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > results) {
				results = data[i];
			}
		}
		System.out.println("[返回值为int]数组的最大元素为：" + results);
		return results;
	}

	// 找出能被8整除的数
	public int[] find8(int[] data) {
		int[] tmp = new int[data.length];
		int counts = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] % 8 == 0) {
				tmp[counts] = data[i];
				counts++;
			}
		}
		// 拷贝数据到新的results
		int[] results = new int[counts];
		for (int i = 0; i < counts; i++) {
			results[i] = tmp[i];
		}
		return results;
	}

	public void test() {
		System.out.println("我没有参数");
	}

	public void test(int a) {
		System.out.println("我有一个参数：" + a);
	}

	public void test(int a, int b) {
		System.out.println("我有两个参数：" + a + "和" + b);
	}
}
