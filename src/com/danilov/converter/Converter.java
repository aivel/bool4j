package com.danilov.converter;

import ru.matlog.bool4j.expression.Expression;

/**
 * 
 * @author ����
 *
 */
public interface Converter {
	
	/**
	 * ��������������� � ����������� �����(� ����������� �� ����������)
	 * @return ���������������� ���������
	 */
	Expression convert(final Expression expression);
	
}
