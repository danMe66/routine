package pers.liudandan.demo.polymorphic;

public class MyFile {
	public long size;
	public String name;

	// 显示文件信息
	public void info()
	{
		System.out.println("文件:" + name + " 大小：" + size);
	}
}
