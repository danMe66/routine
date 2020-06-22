package pers.liudandan.demo.gouzao;

public class Parent {
	private int a;

	public Parent()
	{
		System.out.println("父类的构造方法输出");
	}

	public Parent(int a)
	{
		this.a = a;
		System.out.println("父类的构造方法输出" + this.a);
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return super.toString();
	}
}
