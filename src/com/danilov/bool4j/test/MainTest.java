package com.danilov.bool4j.test;

import com.danilov.bool4j.util.Util;

public class MainTest {

	public static void main(String[] args) {
		ITest tests[] = new ITest[3];
		tests[0] = new Test1();
		tests[1] = new Test2();
		tests[2] = new Test3();
		for (int i = 0; i < tests.length; i++) {
			Util.Log("**************************************************");
			Util.Log("Test #" + i + ": ");
			Util.Log("**************************************************");
			tests[i].test();
		}
	}

}