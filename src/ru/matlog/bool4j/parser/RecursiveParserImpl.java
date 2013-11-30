package ru.matlog.bool4j.parser;

import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.expression.ExpressionType;
import ru.matlog.bool4j.expression.function.Function;
import ru.matlog.bool4j.expression.function.Functions;
import ru.matlog.bool4j.expression.operator.Operator;
import ru.matlog.bool4j.expression.operator.Operators;

public class RecursiveParserImpl implements Parser{

	@Override
	public Expression parse(final String string) {
		Counter count = new Counter();
		return parse(string, count);
	}
	
	public Expression parse(final String string, final Counter count) {
		boolean isFunction = false;
		boolean isVariable = false;
		boolean isConstant = false;
		boolean isOperator = false;
		boolean parentheses = false;
		
		StringBuilder tmp = new StringBuilder();
		Expression exp = null;
		while (count.i < string.length()) {
			char c = string.charAt(count.i);
			if (c == ' ' || c == ')') {
				isVariable = true;
				count.i++;
				break;
			}
			if ((c == '1' || c == '0')) { // i == 0
				isConstant = true;
				tmp.append(c);
				count.i++;
				break;
			}
			if (c != '(') {
				tmp.append(c);
			} else {
				if (parentheses) {
					exp = parse(string, count);
					break;
				}
				parentheses = true;
			}
			if (Functions.contains(tmp.toString())) {
				Function f = Functions.getFunction(tmp.toString());
				exp = new Expression(ExpressionType.FUNCTION);
				Expression args[] = parseArgs(string.substring(count.i));
				exp.setFunction(f);
				f.setArguments(args);
			}
			count.i++;
		}
		if (isVariable) {
			exp = new Expression(ExpressionType.VARIABLE);
			exp.setVariable(tmp.toString());
		}
		if (isConstant) {
			exp = new Expression(ExpressionType.CONSTANT);
			int a = Integer.valueOf(tmp.toString());
			if (a == 1) {
				exp.setConstant(true);
			} else {
				exp.setConstant(false);
			}
			exp.setConstant(Boolean.valueOf(tmp.toString()));
		}
		if (!parentheses) {
			return exp;
		}
		while (true) {
			tmp = new StringBuilder();
			while (count.i < string.length()) {
				char c = string.charAt(count.i);
				if (c == ' ' || c == ')') {
					count.i++;
					return exp;
				}
				tmp.append(c);
				if (Operators.contains(tmp.toString())) {
					isOperator = true;
					count.i += 2;
					break;
				}
				count.i++;
			}
			if (isOperator) {
				Operator op = Operators.getOperator(tmp.toString());
				op.setFirstOperand(exp);
				exp = parse(string, count);
				op.setSecondOperand(exp);
				exp = new Expression(ExpressionType.OPERATOR);
				exp.setOperator(op);
			}
			if (count.i >= string.length()) {
				break;
			}
		}
		return exp;
	}
	
	private Expression parseSecondOperand(final String string, final Counter count, final Operator op) {
		Expression exp = new Expression(ExpressionType.OPERATOR);
		exp.setOperator(op);
		op.setSecondOperand(parse(string, count));
		return exp;
	}
	
	private Expression[] parseArgs(final String str) {
		return null;
	}
	
	private class Counter {
		int i = 0;
	}

}
