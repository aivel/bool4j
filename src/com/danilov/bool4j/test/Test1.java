package com.danilov.bool4j.test;

import java.util.Set;

import ru.matlog.bool4j.expression.Calculable;
import ru.matlog.bool4j.expression.Constant;
import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.expression.ExpressionType;
import ru.matlog.bool4j.expression.RecursiveCalculableFactoryImpl;
import ru.matlog.bool4j.expression.Variable;
import ru.matlog.bool4j.expression.function.Function;
import ru.matlog.bool4j.expression.function.Functions;
import ru.matlog.bool4j.expression.operator.Operator;
import ru.matlog.bool4j.expression.operator.Operators;

import com.danilov.bool4j.util.Util;

public class Test1 implements ITest {

	@Override
	public void test() {
		Variable var1 = new Variable();
		var1.setVariable("x");
		Variable var2 = new Variable();
		var2.setVariable("z");
		Variable var3 = new Variable();
		var3.setVariable("z");
		Variable var4 = new Variable();
		var4.setVariable("y");
		Operator disjOperator = Operators.getOperator("*");
		disjOperator.setFirstOperand(var1);
		disjOperator.setSecondOperand(var2);
		Operator conjOperator1 = Operators.getOperator("+");
		conjOperator1.setFirstOperand(var3);
		conjOperator1.setSecondOperand(var4);
		Operator equalOperator = Operators.getOperator("<=>");
		equalOperator.setFirstOperand(disjOperator);
		equalOperator.setSecondOperand(conjOperator1);
		Function negative = Functions.getFunction("neg");
		negative.setArguments(equalOperator);
		Operator xor = Operators.getOperator("xor");
		xor.setFirstOperand(negative);
		Constant constant = new Constant();
		constant.setValue(true);
		xor.setSecondOperand(constant);
		//neg((x*z)<=>(z+y)) xor 1
		Calculable calc = xor.toCalculable(new RecursiveCalculableFactoryImpl()).with("x", false).with("y", true).with("z", true);
		Set<String> s = calc.getVariableNames();
		boolean v = calc.calculate();
		Util.Log("res = " + v);
		Util.Log(xor.toString());
	}

}
