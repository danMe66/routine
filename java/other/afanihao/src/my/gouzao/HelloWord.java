package my.gouzao;

public class HelloWord {

    public static void main(String[] args) {
        System.out.println("--------------------------------Java类对象--------------------------------");

        Screen screen = new Screen();
        screen.width = 12;
        screen.heigth = 3;
        int p = screen.pixel(screen.width, screen.heigth);
        System.out.println("第一种求像素的方法，结果为：" + p);

        int p1 = screen.pixel1(screen);
        System.out.println("第二种求像素的方法，结果为：" + p1);

        int p2 = screen.pixel2();
        System.out.println("第三种求像素的方法，结果为：" + p2);

        Example example = new Example();
        example.show();
        example.show1();

        System.out.println("--------------------------------demo1--------------------------------");
        int a = 10;
        int b = 20;
        int c = 50;
        example.insertCash(a);// 第一次充值
        example.insertCash(b);// 第二次充值
        example.insertCash(c);// 第三次充值
        System.out.println("充值完成，提取游戏币");
        example.exchange();
        System.out.println("--------------------------------demo2--------------------------------");
        // 笔记：对象=属性+方法
        // 属性：就是数据
        // 方法：就是算法
        // 对象就数据和算法的一个整合体
        // 给它所需的数据-》让他干活-》取出结果
        System.out.println("--------------------------------读取私有属性--------------------------------");
        Exampler exampler = new Exampler();
        exampler.setNumber(12);
        System.out.println("结果为:" + exampler.getNumber());
        System.out.println("--------------------------------类的构造方法--------------------------------");
        GouZao gouZao = new GouZao("小明", 18, true);
        System.out.println("输出:name" + gouZao.name + " age:" + gouZao.age + " sex:" + gouZao.sex);
        // 构造方法在创建时被调用
        // 构造方法是常用方法，一般的类都应该加一个构造方法

        System.out.println("--------------------------------对象的销毁--------------------------------");
        // 只需要创建，不需要销毁，因为Java自己会做垃圾回收
        // GC 垃圾回收机制，回收的不是垃圾，而是不再被使用的对象

        System.out.println("--------------------------------单根继承--------------------------------");
        // A->B->C->D(A继承B，B继承C，C继承D)
        // 如果一个类没有指定父类，则它默认父类就是Object
    }

}
