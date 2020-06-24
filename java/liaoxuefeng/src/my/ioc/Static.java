package my.ioc;

public class Static {
	public static void main(String[] args) {
		Persons ming = new Persons("Xiao Ming", 12);
		Persons hong = new Persons("Xiao Hong", 15);
		ming.number = 88;
		System.out.println(hong.number);
		hong.number = 99;
		System.out.println(ming.number);
		System.out.println(ming.age);
		System.out.println(ming.age);
	}
}

class Persons {
	public String name;
	public int age;

	public static int number;

	public Persons(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
