package ru.matlog.bool4j.closures;

import ru.matlog.bool4j.expression.Expression;

public abstract class ClosureClass {
	public abstract boolean whetherBelongs(final Expression expr);
	public abstract String getStringRepresentation();
}
