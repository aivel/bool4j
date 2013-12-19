package ru.matlog.bool4j.test;

import ru.matlog.bool4j.converter.Converter;
import ru.matlog.bool4j.converter.JPolynomConverter;
import ru.matlog.bool4j.converter.SDNFConverter;
import ru.matlog.bool4j.converter.SKNFConverter;
import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.parser.Parser;
import ru.matlog.bool4j.parser.RecursiveParserImpl;
import ru.matlog.bool4j.util.Util;


public class Test4 implements ITest {

	@Override
	public void test() {
		Parser p = new RecursiveParserImpl();
		Expression exp = p.parse("((x -> (y -> z)) * (x + y))");
		Converter c = new SDNFConverter();
		Expression exp1 = c.convert(exp);
		if (exp1 != null) {
			Util.Log(exp1.toString());
		}
		c = new SKNFConverter();
		exp1 = c.convert(exp);
		if (exp1 != null) {
			Util.Log(exp1.toString());
		}
		c = new JPolynomConverter();
		c.convert(exp);
	}

}
