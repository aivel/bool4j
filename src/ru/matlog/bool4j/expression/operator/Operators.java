package ru.matlog.bool4j.expression.operator;

import java.util.HashMap;
import java.util.Map;

public final class Operators {
	
	private static final Map<String, Class> operators = new HashMap<String, Class>();
	
	//multyply
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
	} 
	
	//->
	public static final class IMPLICATION extends Operator {

		public static final String REPRESENTATION = "->";
		
		@Override
		public boolean apply(Map<String, Boolean> variables) {
			Boolean res = true;
			Boolean first = getFirstOperand().calculate(variables);
			Boolean second = getSecondOperand().calculate(variables);
			if ((first == true) && (second == false)) {
				res = false;
			}
			return res;
		}

		@Override
		public String getStringRepresentation() {
			return REPRESENTATION;
		}
	} 
	
	//xor
	public static final class XOR extends Operator {
		
		public static final String REPRESENTATION = "xor";
		
		@Override
		public boolean apply(Map<String, Boolean> variables) {
			Boolean res = true;
			Boolean first = getFirstOperand().calculate(variables);
			Boolean second = getSecondOperand().calculate(variables);
			if (first == second) {
				res = false;
			}
			return res;
		}

		@Override
		public String getStringRepresentation() {
			return REPRESENTATION;
		}
	} 
	
	//equ
	public static final class EQUAL extends Operator {
		
		public static final String REPRESENTATION = "<=>";
		
		@Override
		public boolean apply(Map<String, Boolean> variables) {
			Boolean res = true;
			Boolean first = getFirstOperand().calculate(variables);
			Boolean second = getSecondOperand().calculate(variables);
			if (first != second) {
				res = false;
			}
			return res;
		}

		@Override
		public String getStringRepresentation() {
			return REPRESENTATION;
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
