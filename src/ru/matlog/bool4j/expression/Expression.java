package ru.matlog.bool4j.expression;

import java.util.Map;
import java.util.Set;

public abstract class Expression {
	
	/**
	 * Вычисление значения выражения
	 * @param variables набор переменных
	 * @return значение полученное в результате вычислений
	 */
    public abstract Boolean calculate(final Map<String, Boolean> variables);
    
    /**
     * 
     * @return имена всех переменных данного выражения
     */
    public abstract Set<String> getVariablesNames();
    
    /**
     * 
     * @return тип выражения (константа, функия, оператор etc)
     */
    public abstract ExpressionType getType();
    
    /**
     * Получение объекта Calculable (для абстрагирования от конкретной реализации вычислений)
     * @param calculableFactory фабрика объектов типа Calculable
     * @return объект Calculable
     */
    public Calculable toCalculable(final CalculableFactory calculableFactory) {
		return calculableFactory.newCalculable(this); 
    }
    

    @Override
    public abstract String toString();
}
