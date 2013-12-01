/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.matlog.bool4j.expression;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Max
 */
public class Constant extends Expression {
    Boolean value;

    @Override
    public Boolean calculate(Map<String, Boolean> variables) {
        return value;
    }

    @Override
    public void setExpression(Object elem_expr) {
        if (!(elem_expr instanceof Boolean)) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        value = (Boolean) elem_expr;
    }

    @Override
    public Set<String> getVariablesNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        if (value) {
            return "1";
        } else {
            return "0";
        }
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.CONSTANT;
    }
}
