package my.ioc.interfaces;

/**
 * 接口的实现
 * 
 * @author mini
 *
 */
public class OneinterfacesImpl implements Oneinterfaces {

	@Override
	public String Hello(String msg) {
		return "接口实现输出:" + msg;
	}

}
