package ru.matlog.bool4j.expression;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ru.matlog.bool4j.expression.function.Function;
import ru.matlog.bool4j.expression.operator.Operator;

public class Expression {
	
	private ExpressionType type;
	private Operator operator = null;
	private Function function = null;
	private Boolean constant = null;
	private String variable = null;
	
	
	public Expression(final ExpressionType type) {
		this.type = type;
	}
	
	public Calculable toCalculable(final CalculableFactory calculableFactory) {
		return calculableFactory.newCalculable(this); 
	}
	
	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		if (type != ExpressionType.OPERATOR) {
			throw new IllegalMethodException("Type of expression is " + type.toString());
		}
		this.operator = operator;
	}



	public Function getFunction() {
		return function;
	}



	public void setFunction(Function function) {
		if (type != ExpressionType.FUNCTION) {
			throw new IllegalMethodException("Type of expression is " + type.toString());
		}
		this.function = function;
	}



	public Boolean getConstant() {
		return constant;
	}



	public void setConstant(Boolean constant) {
		if (type != ExpressionType.CONSTANT) {
			throw new IllegalMethodException("Type of expression is " + type.toString());
		}
		this.constant = constant;
	}



	public String getVariable() {
		return variable;
	}

	public ExpressionType getType() {
		return type;
	}


	public void setVariable(String variable) {
		if (type != ExpressionType.VARIABLE) {
			throw new IllegalMethodException("Type of expression is " + type.toString());
		}
		this.variable = variable;
	}



	public Boolean calculate(final Map<String, Boolean> variables) {
		Boolean value = false;
		switch (type) {
		case CONSTANT:
			value = constant;
			break;
		case FUNCTION:
			value = function.apply(variables);
			break;
		case OPERATOR:
			value = operator.apply(variables);
			break;
		case VARIABLE:
			if (!variables.containsKey(variable)) {
				throw new CalculationException("Variable " + variable + " is not specified!");
			}
			value = variables.get(variable);
			break;
		default:
			break;
		}
		return value;
	}
	
	public Set<String> getVariablesNames() {
		Set<String> set = new HashSet<String>();
		switch (type) {
		case CONSTANT:
			break;
		case FUNCTION:
			set = function.getVariablesNames();
			break;
		case OPERATOR:
			set = operator.getVariablesNames();
			break;
		case VARIABLE:
			set.add(variable);
			break;
		default:
			break;
		}
		return set;	
	}
	
	public String toString() {
		String str = null;
		switch(type) {
		case CONSTANT:
			if (constant) {
				str = "1";
			} else {
				str = "0";
			}
			break;
		case FUNCTION:
			str = function.toString();
			break;
		case OPERATOR:
			str = operator.toString();
			break;
		case VARIABLE:
			str = variable;
			break;
		default:
			break;
		}
		return str;
	}

}
