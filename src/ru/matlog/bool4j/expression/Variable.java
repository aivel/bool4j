/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.matlog.bool4j.expression;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Max
 */
public class Variable extends Expression {
    String var;

    @Override
    public Boolean calculate(Map<String, Boolean> variables) {
        if (!variables.containsKey(var))
                throw new CalculationException("Variable " + var + " is not specified!");
        
	return variables.get(var);
    }

    @Override
    public void setExpression(Object elem_expr) {
        if (!(elem_expr instanceof String))
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        var = (String) elem_expr;
    }

    @Override
    public Set<String> getVariablesNames() {
        Set<String> set = new HashSet<>();
        set.add(var);
        return set;
    }

    @Override
    public String toString() {
        return var;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.VARIABLE;
    }
    
}
