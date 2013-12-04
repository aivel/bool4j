package com.danilov.bool4j.test;

import java.util.Set;

import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.parser.Parser;
import ru.matlog.bool4j.parser.RecursiveParserImpl;

import com.danilov.bool4j.util.Util;

public class Test2 implements ITest{

	@Override
	public void test() {
		Parser p = new RecursiveParserImpl();
		Expression exp = p.parse("(x + y + z + z + y + u)");
		Util.Log("Desire: (x + y + z + z + y + u)");
		Util.Log("Result:" + exp.toString());
	    exp = p.parse("(x + y + (z + z) + y + u)");
		Util.Log("Desire: (x + y + (z + z) + y + u)");
		Util.Log("Result:" + exp.toString());
	    exp = p.parse("(x + y + ((z <=> z) xor y) + u)");
		Util.Log("Desire: (x + y + ((z <=> z) xor y) + u)");
		Util.Log("Result:" + exp.toString());
		exp = p.parse("(x + (y + ((z -> z) xor y)) + u)");
		Util.Log("Desire: (x + (y + ((z -> z) xor y)) + u)");
		Util.Log("Result:" + exp.toString());
	}

}
