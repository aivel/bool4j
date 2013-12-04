package ru.matlog.bool4j.expression;

import java.util.Map;
import java.util.Set;

public interface Calculable {	
	public boolean calculate();
	public Calculable with(final String variableName, final Boolean variableValue);
	public Calculable with(final Map<String, Boolean> variables);
	public Set<String> getVariableNames();
}
