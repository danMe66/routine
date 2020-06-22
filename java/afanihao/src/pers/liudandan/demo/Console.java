package pers.liudandan.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
	BufferedReader bufferedReader;

	public Console() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		bufferedReader = new BufferedReader(inputStreamReader);
	}

	// 输入显示一个字符串
	public void print(String s) {
		System.out.println(s);
	}

	// 输出显示一个字符串
	public void printIn(String s) {
		System.out.println(s);
	}
}
