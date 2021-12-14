package my.genericclass;

public class Student {
    public int number;
    public String name;
    public int age;

    public Student(int numbet, String name, int age) {
        this.number = numbet;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "学号：" + number + " 姓名：" + name + " 年龄：" + age;
    }
}
