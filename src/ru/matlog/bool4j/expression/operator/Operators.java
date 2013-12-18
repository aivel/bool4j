package ru.matlog.bool4j.expression.operator;

import java.util.HashMap;
import java.util.Map;

import ru.matlog.bool4j.expression.ExpressionType;

public final class Operators {

    private static final Map<String, Class> operators = new HashMap<>();

    //multiply
    public static final class CONJUNCTION extends Operator {
        public static final String REPRESENTATION = "*";

        @Override
        public boolean apply(Map<String, Boolean> variables) {
            Boolean first = getFirstOperand().calculate(variables);
            Boolean second = getSecondOperand().calculate(variables);
            return first && second;
        }

        @Override
        public String getStringRepresentation() {
            return REPRESENTATION;
        }

        @Override
        public ExpressionType getType() {
            return ExpressionType.OPERATOR;
        }
    }

    //sum
    public static final class DISJUNCTION extends Operator {
        public static final String REPRESENTATION = "+";

        @Override
        public boolean apply(Map<String, Boolean> variables) {
            Boolean first = getFirstOperand().calculate(variables);
            Boolean second = getSecondOperand().calculate(variables);
            return first || second;
        }

        @Override
        public String getStringRepresentation() {
            return REPRESENTATION;
        }

        @Override
        public ExpressionType getType() {
            return ExpressionType.OPERATOR;
        }
    }

    //->
    public static final class IMPLICATION extends Operator {
        public static final String REPRESENTATION = "->";

        @Override
        public boolean apply(Map<String, Boolean> variables) {
            Boolean first = getFirstOperand().calculate(variables);
            Boolean second = getSecondOperand().calculate(variables);
            return !first || second;
        }

        @Override
        public String getStringRepresentation() {
            return REPRESENTATION;
        }

        @Override
        public ExpressionType getType() {
            return ExpressionType.OPERATOR;
        }
    }

    //xor
    public static final class XOR extends Operator {
        public static final String REPRESENTATION = "xor";

        @Override
        public boolean apply(Map<String, Boolean> variables) {
            Boolean first = getFirstOperand().calculate(variables);
            Boolean second = getSecondOperand().calculate(variables);
            return first ^ second;
        }

        @Override
        public String getStringRepresentation() {
            return REPRESENTATION;
        }

        @Override
        public ExpressionType getType() {
            return ExpressionType.OPERATOR;
        }
    }

    //equ
    public static final class EQUAL extends Operator {
        public static final String REPRESENTATION = "<=>";

        @Override
        public boolean apply(Map<String, Boolean> variables) {
            Boolean first = getFirstOperand().calculate(variables);
            Boolean second = getSecondOperand().calculate(variables);
            return (!first || second) && (first || !second);
        }

        @Override
        public String getStringRepresentation() {
            return REPRESENTATION;
        }

        @Override
        public ExpressionType getType() {
            return ExpressionType.OPERATOR;
        }
    }

    static {
        operators.put(DISJUNCTION.REPRESENTATION, DISJUNCTION.class);
        operators.put(CONJUNCTION.REPRESENTATION, CONJUNCTION.class);
        operators.put(IMPLICATION.REPRESENTATION, IMPLICATION.class);
        operators.put(XOR.REPRESENTATION, XOR.class);
        operators.put(EQUAL.REPRESENTATION, EQUAL.class);
    }

    public static void add(final Class operator, final String representation) {
        operators.put(representation, operator);
    }

	public static boolean contains(final String str) {
		return operators.containsKey(str);
	}

    public static Operator getOperator(final String representation) {
        Class clazz = operators.get(representation);
        Operator o = null;
        try {
            o = (Operator) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
