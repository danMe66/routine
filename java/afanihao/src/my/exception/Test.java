package my.exception;

public class Test {
    public static void step1() throws Exception {
        System.out.println("step1正常");
    }

    public static void step2() throws Exception {
        throw new Exception("step2 出现异常");
    }

    public static void step3() throws Exception {
        System.out.println("step3正常");
    }

    public static void step4() throws Exception {
        System.out.println("step4正常");
    }

    public static void step5() throws Exception {
        System.out.println("step5正常");
    }

    public static void clearJoibs() {
        System.out.println("清理完毕");
    }

    public static void service() throws Exception {
        step1();
        step2();
        step3();
        step4();
        step5();
//		clearJoibs();
    }

    public static void main(String[] args) {
        try {
            service();
        } catch (MyException e) {
            System.err.println("MyException抛出的异常=》" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            clearJoibs();
        }

    }
}
