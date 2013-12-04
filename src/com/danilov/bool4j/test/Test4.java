package com.danilov.bool4j.test;

import com.danilov.bool4j.util.Util;
import com.danilov.converter.Converter;
import com.danilov.converter.DNFConverter;

import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.parser.Parser;
import ru.matlog.bool4j.parser.RecursiveParserImpl;

public class Test4 implements ITest {

	@Override
	public void test() {
		Parser p = new RecursiveParserImpl();
		Expression exp = p.parse("(x + y + ((z <=> z) xor y) + u)");
		Converter c = new DNFConverter();
		exp = c.convert(exp);
		Util.Log(exp.toString());
	}

}
