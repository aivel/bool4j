package ru.matlog.bool4j.expression;

import java.util.Map;
import java.util.Set;

public abstract class Expression {
    public abstract Boolean calculate(final Map<String, Boolean> variables);
    public abstract void setExpression(Object expr);
    public abstract Set<String> getVariablesNames();
    @Override
    public abstract String toString();
    public abstract ExpressionType getType();
    
    public Calculable toCalculable(final CalculableFactory calculableFactory) {
		return calculableFactory.newCalculable(this); 
    }
}
