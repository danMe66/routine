package pers.liudandan.demo;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String msg;

	public String execute() {
		setMsg("我是liudandan");
		return SUCCESS;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
