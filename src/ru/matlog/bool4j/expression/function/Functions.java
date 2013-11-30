package ru.matlog.bool4j.expression.function;

import java.util.HashMap;
import java.util.Map;

import ru.matlog.bool4j.expression.Expression;
import ru.matlog.bool4j.expression.ExpressionType;

public final class Functions {
    private static final Map<String, Class> functions = new HashMap<>();

    public static final class NEGATIVE extends Function {

        @Override
        public boolean apply(Map<String, Boolean> variables) {
            int quantity = getArgumentQuantity();
            Expression arguments[] = getArguments();
            Boolean val = arguments[0].calculate(variables);
            val = !val;
            return val;
        }

        @Override
        public void init() {
            setArgumentQuantity(1);
            setStringRepresentation("neg");
        }

        @Override
        public Boolean calculate(Map<String, Boolean> variables) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setExpression(Object elem_expr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ExpressionType getType() {
            return ExpressionType.FUNCTION;
        }
    };

    static {
        functions.put("neg", NEGATIVE.class);
    }

    public static void add(final Class clazz, final String representation) {
        functions.put(representation, clazz);
    }

    public static Function getFunction(final String representation) {
        Class clazz = functions.get(representation);
        Function o = null;
        try {
            o = (Function) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
