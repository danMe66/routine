package my.exception;

public class Coverter {

	/**
	 * 把一个字符串转化为整数
	 * 
	 * @param str
	 * @return
	 */
	public int str2int(String str) throws Exception {
		if (str.length() > 11) {
			// ①
			Exception exception = new Exception("超出范围");
			throw exception;
		}
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!isValid(ch)) {
				// ②
//				throw new Exception("非法字符");
				throw new MyException(i, ch);
			}
			result = result * 10 + (ch - '0');
		}
		return result;
	}

	/**
	 * 检查是否存在非法字符
	 * 
	 * @param ch
	 * @return
	 */
	private boolean isValid(char ch) {
		if (ch >= '0' && ch <= '9')
			return true;
		if (ch == '_')
			return true;
		return false;
	}
}
