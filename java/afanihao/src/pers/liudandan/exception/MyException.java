package pers.liudandan.exception;

public class MyException extends Exception {

	private static final long serialVersionUID = 1L;

	public int pos;

	public char ch;

	public MyException(int pos, char ch) {
		this.pos = pos;
		this.ch = ch;
	}

	@Override
	public String getMessage() {
		return "非法字符：" + ch + " 位置：" + pos;
	}

}
