package com.danilov.bool4j.test;

import com.danilov.bool4j.util.Util;
import com.danilov.converter.Converter;
import com.danilov.converter.DNFConverter;
import com.danilov.converter.KNFConverter;

import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.parser.Parser;
import ru.matlog.bool4j.parser.RecursiveParserImpl;

public class Test4 implements ITest {

	@Override
	public void test() {
		Parser p = new RecursiveParserImpl();
		Expression exp = p.parse("(x + y + ((z <=> z) -> y) + u)");
		Converter c = new DNFConverter();
		Expression exp1 = c.convert(exp);
		if (exp1 != null) {
			Util.Log(exp1.toString());
		}
		c = new KNFConverter();
		exp1 = c.convert(exp);
		if (exp1 != null) {
			Util.Log(exp1.toString());
		}
	}

}
