package my.abstractclass;

/**
 * 超级汽车飞机
 *
 * @author mini
 */
public abstract class RootCarP {
    // 抽象类不能被实例化
    // 抽象类在使用时，必须派生子类，把抽象方法实现出来
    // 抽象类是一种约束，规定是什么，应该做什么，具体的需要抽象类的子类去实现

    private Wheel wheel;

    private Wing wing;

    public abstract void run();

    public abstract void fly();
}
