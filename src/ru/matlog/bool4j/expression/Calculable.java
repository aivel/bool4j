package ru.matlog.bool4j.expression;

import java.util.Set;

public interface Calculable {	
	public boolean calculate();
	public Calculable with(final String variableName, final Boolean variableValue);
	public Set<String> getVariableNames();
}
