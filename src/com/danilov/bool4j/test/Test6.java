package com.danilov.bool4j.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.parser.Parser;
import ru.matlog.bool4j.parser.RecursiveParserImpl;

import com.danilov.bool4j.util.Util;
import com.danilov.converter.TruthTable;

public class Test6 implements ITest {

	@Override
	public void test() {
		ArrayList<String> vl = new ArrayList<>();
		
		Util.Log("getVarsDefenitionRange():");
		
		LinkedList<LinkedList<Boolean>> r = TruthTable.getVarsDefenitionRange(vl);
		
		for (LinkedList<Boolean> i: r) {
			for (Boolean j: i)
				Util.LogNoLn(j.toString() + " ");
			
			Util.LogNoLn("\n");
		}
		
		Util.Log("getTruthTable():");
		
		Parser p = new RecursiveParserImpl();
		Expression expr = p.parse("1");
		ArrayList<Expression> el = new ArrayList<>();
		el.add(expr);
		
		Map<String, List<Boolean>> trt = TruthTable.getTruthTable(vl, el);
		
		Util.Log("String representation:\n" + TruthTable.toString(trt));
	}

}
