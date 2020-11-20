package my.stuclass;

/**
 * Student 类
 *
 * @author mini
 */
public class Students {

    // 类student的name属性
    public String name;

    // age属性
    public int age;

    // sex属性
    public boolean sex;

//	public Students(String name, int age, boolean sex) {
//		this.name = name;
//		this.age = age;
//		this.sex = sex;
//	}

    // 属性也可以是类的一个对象
    public StudentCards studenCards = new StudentCards();

    public void show(int number) {
        System.out.println("报数到 " + number + " 停止");
        for (int i = 0; i <= number; i++) {
            System.out.println("开始报数：" + i);
        }
    }

    public String toString() {
        String s = "姓名：" + name + "年龄：" + age + "性别:" + sex;
        return s;
    }
}
