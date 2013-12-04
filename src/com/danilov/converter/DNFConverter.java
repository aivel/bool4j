package com.danilov.converter;

import java.util.Map;
import java.util.Set;

import ru.matlog.bool4j.expression.Calculable;
import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.expression.RecursiveCalculableFactoryImpl;

import com.danilov.bool4j.util.VariablesSet;

/**
 * Конвертирование в дизъюнктивную нормальную форму
 * @author Семён
 *
 */
public class DNFConverter implements Converter {

	@Override
	public Expression convert(final Expression expression) {
		Calculable calculable = expression.toCalculable(new RecursiveCalculableFactoryImpl());
		Set<String> vars = expression.getVariablesNames();
		VariablesSet variablesSet = new VariablesSet(vars);
		while(variablesSet.notEnd()) {
			Map<String, Boolean> variables = variablesSet.get();
			Boolean calculatedValue = calculable.with(variables).calculate();
			if (calculatedValue) {
				
			}
		}
		return null;
	}

}
