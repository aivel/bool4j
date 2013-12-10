package ru.matlog.bool4j.closures;

import java.util.HashMap;
import java.util.Map;

import ru.matlog.bool4j.expression.Expression;

public class ClosureClasses {
	/*
	 * Implements T0, T1, M, S, L closure classes.
	 */
	
	private static final Map<String, Class> classes = new HashMap<>();
	
    public static final class T0 extends ClosureClass {
    // T0
        public static final String REPRESENTATION = "T0";

        @Override
        public boolean whetherBelongs(final Expression expr, final Map<String, Boolean> vars) {
        	HashMap<String, Boolean> variables = new HashMap<>();
        	
        	for(String var_name: expr.getVariablesNames()) {
        		variables.put(var_name, false);
        	}
        	
            return (variables.size() > 0) && (expr.calculate(variables) == false);
        }

        @Override
        public String getStringRepresentation() {
            return REPRESENTATION;
        }
    }
    
    public static final class T1 extends ClosureClass {
    // T1
        public static final String REPRESENTATION = "T1";

        @Override
        public boolean whetherBelongs(final Expression expr, final Map<String, Boolean> vars) {
        	HashMap<String, Boolean> variables = new HashMap<>();
        	
        	for(String var_name: expr.getVariablesNames()) {
        		variables.put(var_name, true);
        	}
        	
            return (variables.size() > 0) && (expr.calculate(variables) == true);
        }

        @Override
        public String getStringRepresentation() {
            return REPRESENTATION;
        }
    }
    
    public static final class S extends ClosureClass {
        // S
            public static final String REPRESENTATION = "S";

            @Override
            public boolean whetherBelongs(final Expression expr, final Map<String, Boolean> vars) {      
            	boolean f_neg_result = !expr.calculate(vars);
            	
            	HashMap<String, Boolean> neg_vars = new HashMap<>();
            	
            	for(String var_name: vars.keySet()) {
            		neg_vars.put(var_name, !vars.get(var_name));
            	} 
            	
                return f_neg_result == expr.calculate(neg_vars);
            }

            @Override
            public String getStringRepresentation() {
                return REPRESENTATION;
            }
    }
    
    static {
        classes.put(T0.REPRESENTATION, T0.class);
        classes.put(T1.REPRESENTATION, T1.class);
        classes.put(S.REPRESENTATION, S.class);
    }
    
    public static boolean contains(final String key) {
		return classes.containsKey(key);
	}
    
    public static ClosureClass getClosureClass(final String representation) {
        Class clazz = classes.get(representation);
        ClosureClass cc = null;
        
        try {
            cc = (ClosureClass) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cc;
    }
}
