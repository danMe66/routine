package my.container;

public class Student {
	// 类student的name属性
	public String name;

	// age属性
	public int age;

	// sex属性
	public boolean sex;

	public Student(String name, int age, boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String toString() {
		String s = "姓名：" + name + "年龄：" + age + "性别:" + sex;
		return s;
	}
}
