package pers.liudandan.demo;

public class MyMatch {

	public void getMax(int[] data)
	{
		int results = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] > results)
			{
				results = data[i];
			}
		}
		System.out.println("数组的最大元素为：" + results);
	}
	
	public int getMax2(int[] data)
	{
		int results = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] > results)
			{
				results = data[i];
			}
		}
		System.out.println("[返回值为int]数组的最大元素为：" + results);
		return results;
	}

}
