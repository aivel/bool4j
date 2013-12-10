package com.danilov.converter;

/*
 * Конвертер выражения в полином Жегалкина
 */

import java.util.List;
import java.util.Map;

import ru.matlog.bool4j.expression.Expression;

public class JPolynomConverter implements Converter {

	@Override
	public Expression convert(Expression expression) {
		return null;
	}

	private Expression toExpression(List<Map<String, Boolean>> variablesSets,
			List<String> keySet) {
		Expression finalResult = null;
		
		return finalResult;
	}

}
