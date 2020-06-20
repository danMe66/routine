package pers.liudandan.demo.container;

public class HelloWord {
	public static void main(String[] args) {
		Student[] ss = new Student[4];
		ss[0] = new Student("1号", 18, true);
		ss[1] = new Student("2号", 19, true);
		ss[2] = new Student("3号", 20, true);
		ss[3] = new Student("4号", 21, true);

		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i].toString());
		}
	}

}
