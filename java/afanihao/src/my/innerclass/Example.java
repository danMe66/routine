package my.innerclass;

import pers.liudandan.interfaceclass.VideoPlay;

/**
 * 内部类和外部类
 * 
 * @author mini
 *
 */
public class Example {

	public int number = 55;

	public void show() {
		System.out.println("Example-我是外部类");
		ABC abc = new ABC();
		abc.show();
		videoPlay.mp4("匿名内部类.mp4");
	}

	public void say() {
		System.out.println("Example的say");
	}

	// 内部类
	public class ABC {

		public int n;

		public void show() {
			System.out.println("Example::ABC-我是内部类");
			// 在内部类中可以直接访问当前外部对象
			Example.this.number = 66;
			System.out.println("Example.this.number的值为:" + Example.this.number);
			Example.this.say();
			say();// 名称唯一的话可以直接这样写，代替 Example.this.say();
		}
	}

	// 匿名内部类
	VideoPlay videoPlay = new VideoPlay() {

		@Override
		public void mp4(String name) {
			System.out.println("LeiDiPlay 输出-" + name);
		}
	};
}
