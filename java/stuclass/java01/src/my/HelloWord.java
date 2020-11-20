package my;

public class HelloWord {

    public static void main(String[] args) {
        System.out.println("--Java的类和属性--");
        Students students = new Students();
        students.name = "小马";
        students.age = 18;
        students.sex = true;
        System.out.println(students.name);
        System.out.println(students.age);
        System.out.println(students.age);
        System.out.println("--EXIT--");
    }

}
