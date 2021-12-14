package my.ioc.interfaces;

/**
 * 接口的使用
 *
 * @author mini
 */
public class Main {

    public static void main(String[] args) {
        Oneinterfaces oneinterfaces = new OneinterfacesImpl();
        System.out.println("输出：" + oneinterfaces.Hello("参数msg的值"));
    }

}
