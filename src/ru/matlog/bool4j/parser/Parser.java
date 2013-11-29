package ru.matlog.bool4j.parser;

import ru.matlog.bool4j.expression.Expression;

public interface Parser {
	
	public Expression parse(final Object object);
	
}
