package my.ioc;

public class PrivateField {

	public static void main(String[] args) {
		Person ming = new Person();
		ming.setName("Xiao Ming"); // 设置name
		ming.setAge(12); // 设置age
		System.out.println(ming.getName() + ", " + ming.getAge());

	}

}

class Person {
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
