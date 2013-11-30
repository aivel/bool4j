package com.danilov.bool4j.test;

import java.util.Set;

import ru.matlog.bool4j.expression.Calculable;
import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.expression.ExpressionType;
import ru.matlog.bool4j.expression.RecursiveCalculableFactoryImpl;
import ru.matlog.bool4j.expression.function.Function;
import ru.matlog.bool4j.expression.function.Functions;
import ru.matlog.bool4j.expression.operator.Operator;
import ru.matlog.bool4j.expression.operator.Operators;

import com.danilov.bool4j.util.Util;
import ru.matlog.bool4j.expression.Constant;
import ru.matlog.bool4j.expression.Variable;

public class MainTest {

	public static void main(String[] args) {
		Operator exp = new Operators.XOR();
		Variable var1 = new Variable();
		var1.setExpression("x");
		Variable var2 = new Variable();
		var2.setExpression("z");
		Variable var3 = new Variable();
		var3.setExpression("z");
		Variable var4 = new Variable();
		var4.setExpression("y");
		Operator disjOperator = Operators.getOperator("*");
		Operator disj = new Operators.CONJUNCTION();
		disj.setOperator(disjOperator);
		disjOperator.setFirstOperand(var1);
		disjOperator.setSecondOperand(var2);
		Operator conjOperator1 = Operators.getOperator("+");
		Operator conj1 = new Operators.CONJUNCTION();
		conj1.setOperator(conjOperator1);
		conjOperator1.setFirstOperand(var3);
		conjOperator1.setSecondOperand(var4);
		Operator equalOperator = Operators.getOperator("<=>");
		Operator equal = new Operators.EQUAL();
		equal.setOperator(equalOperator);
		equalOperator.setFirstOperand(disj);
		equalOperator.setSecondOperand(conj1);
		Function f = Functions.getFunction("neg");
		f.setArguments(equal);
		Function neg = new Functions.NEGATIVE();
		neg.setExpression(f);
		Operator xor = Operators.getOperator("xor");
		xor.setFirstOperand(neg);
		Constant constant = new Constant();
		constant.setExpression(true);
		xor.setSecondOperand(constant);
		exp.setOperator(xor);
		//neg((x * z )+ (z + y))
		Calculable calc = exp.toCalculable(new RecursiveCalculableFactoryImpl()).with("x", false).with("y", true).with("z", true);
		Set<String> s = calc.getVariableNames();
		boolean v = calc.calculate();
		Util.Log("res = " + v);
		Util.Log(exp.toString());
	}

}
