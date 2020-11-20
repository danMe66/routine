package my.innerclass;

public class HelloWord {

    public static void main(String[] args) {
        Example example = new Example();
        example.show();

        // 内部类的使用
        Example.ABC abc = example.new ABC();
        abc.show();

        // 静态内部类
        // 在外边使用时，类名要加前缀Example.XXX
        // 可以独立创建,和普通类差不多
        // 对外部类保留特权，可以无视private限制
        // 当一个内部类改成静态类之后，丧失了特权，同时也获得了独立性

    }

}
