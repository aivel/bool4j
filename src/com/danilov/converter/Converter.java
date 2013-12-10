package com.danilov.converter;

import ru.matlog.bool4j.expression.Expression;

/**
 * 
 * @author Семён
 *
 */
public interface Converter {
	
	/**
	 * Конвертирование в определнную форму(в зависимости от реализации)
	 * @return конвертированное выражение
	 */
	Expression convert(final Expression expression);
	
}
