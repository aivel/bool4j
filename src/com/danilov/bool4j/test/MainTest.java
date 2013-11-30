package com.danilov.bool4j.test;

public class MainTest {

	public static void main(String[] args) {
		ITest tests[] = new ITest[2];
		tests[0] = new Test1();
		tests[1] = new Test2();
		for (int i = 0; i < tests.length; i++) {
			tests[i].test();
		}
	}

}
