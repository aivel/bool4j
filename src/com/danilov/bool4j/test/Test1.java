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

public class Test1 implements ITest {

	@Override
	public void test() {
		Expression exp = new Expression(ExpressionType.OPERATOR);
		Expression var1 = new Expression(ExpressionType.VARIABLE);
		var1.setVariable("x");
		Expression var2 = new Expression(ExpressionType.VARIABLE);
		var2.setVariable("z");
		Expression var3 = new Expression(ExpressionType.VARIABLE);
		var3.setVariable("z");
		Expression var4 = new Expression(ExpressionType.VARIABLE);
		var4.setVariable("y");
		Operator disjOperator = Operators.getOperator("*");
		Expression disj = new Expression(ExpressionType.OPERATOR);
		disj.setOperator(disjOperator);
		disjOperator.setFirstOperand(var1);
		disjOperator.setSecondOperand(var2);
		Operator conjOperator1 = Operators.getOperator("+");
		Expression conj1 = new Expression(ExpressionType.OPERATOR);
		conj1.setOperator(conjOperator1);
		conjOperator1.setFirstOperand(var3);
		conjOperator1.setSecondOperand(var4);
		Operator equalOperator = Operators.getOperator("<=>");
		Expression equal = new Expression(ExpressionType.OPERATOR);
		equal.setOperator(equalOperator);
		equalOperator.setFirstOperand(disj);
		equalOperator.setSecondOperand(conj1);
		Function f = Functions.getFunction("neg");
		f.setArguments(equal);
		Expression neg = new Expression(ExpressionType.FUNCTION);
		neg.setFunction(f);
		Operator xor = Operators.getOperator("xor");
		xor.setFirstOperand(neg);
		Expression constant = new Expression(ExpressionType.CONSTANT);
		constant.setConstant(true);
		xor.setSecondOperand(constant);
		exp.setOperator(xor);
		//neg((x*z)<=>(z+y)) xor 1
		Calculable calc = exp.toCalculable(new RecursiveCalculableFactoryImpl()).with("x", false).with("y", true).with("z", true);
		Set<String> s = calc.getVariableNames();
		boolean v = calc.calculate();
		Util.Log(this.getClass().getSimpleName() + ": ");
		Util.Log("res = " + v);
		Util.Log(exp.toString());
	}

}
