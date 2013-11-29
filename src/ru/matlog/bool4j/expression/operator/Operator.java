package ru.matlog.bool4j.expression.operator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.expression.ExpressionType;

public abstract class Operator {

	private Expression firstOperand;
	private Expression secondOperand;


	public Operator() {
	}
	
	public Expression getFirstOperand() {
		return firstOperand;
	}



	public void setFirstOperand(Expression firstOperand) {
		this.firstOperand = firstOperand;
	}



	public Expression getSecondOperand() {
		return secondOperand;
	}



	public void setSecondOperand(Expression secondOperand) {
		this.secondOperand = secondOperand;
	}

	
	public abstract String getStringRepresentation();


	public abstract boolean apply(final Map<String, Boolean> variables);


	public Set<String> getVariablesNames() {
		Set<String> set = new HashSet<String>();
		set.addAll(getFirstOperand().getVariablesNames());
		set.addAll(getSecondOperand().getVariablesNames());
		return set;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ExpressionType type1 = firstOperand.getType();
		if (type1 == ExpressionType.OPERATOR) {
			builder.append("(");
			builder.append(firstOperand.toString());
			builder.append(")");
		} else {
			builder.append(firstOperand.toString());
		}
		builder.append(" ");
		builder.append(getStringRepresentation());
		builder.append(" ");
		ExpressionType type2 = secondOperand.getType();
		if (type2 == ExpressionType.OPERATOR) {
			builder.append("(");
			builder.append(secondOperand.toString());
			builder.append(")");
		} else {
			builder.append(secondOperand.toString());
		}
		return builder.toString();
	}

}
