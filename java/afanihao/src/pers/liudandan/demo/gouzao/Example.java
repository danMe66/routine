package pers.liudandan.demo.gouzao;

public class Example {
	public int number = 100;

	public void show() {
		System.out.println("方法show的number的值为：" + this.number);
		System.out.println("number的值为：" + number);
	}

	public void show1() {
		// 此处的number为局部变量，而Example里边的number是属性（全局变量）
		int number = 12;
		System.out.println("方法show1的number的值为：" + this.number);
		// 变量重名的时候不要省略this去使用变量
		System.out.println("方法show1的number的值为：" + number);
	}

	public void insertCash(int cash) {
		if (cash > 20) {
			System.out.println("机器只能识别小于等于20元的纸币");
			return;
		}
		this.money += cash;
		System.out.println("当前余额：" + this.money);
	}

	public int money;

	public void exchange() {
		int cash = this.money / 1;
		System.out.println("您换取游戏币的数量为：" + cash);
		this.money = 0;
		System.out.println("当前余额：" + money);
	}

	/**
	 * 单元测试
	 */
	public static void main(String[] args) {
		Example example =new Example();
		example.insertCash(10);
		example.insertCash(20);
		example.insertCash(50);
		System.out.println("测试完毕");
	}
}
