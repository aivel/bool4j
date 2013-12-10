package ru.matlog.bool4j.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CalculableRecursiveImpl implements Calculable{
	private Map<String, Boolean> variables;
	private Expression expression;
	
	public CalculableRecursiveImpl(final Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public boolean calculate() {
		return expression.calculate(variables);
	}

	@Override
	public Calculable with(String variableName, Boolean variableValue) {
		if (variables == null) {
			variables = new HashMap<String, Boolean>();
		}
		variables.put(variableName, variableValue);
		return this;
	}

	@Override
	public Set<String> getVariableNames() {
            return expression.getVariablesNames();
	}

	@Override
	public Calculable with(Map<String, Boolean> variables) {
		if (this.variables == null) {
			this.variables = variables;
		} else {
			this.variables.putAll(variables);
		}
		return this;
	}
}
