package pers.liudandan.exception;

public class HelloWord {

	public static void main(String[] args) {
		Coverter coverter = new Coverter();
		try {
			int result = coverter.str2int("12f121");
			System.out.println("转换结果：" + result);
		} catch (MyException e) {
			System.err.println("MyException抛出的异常=》" + e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
