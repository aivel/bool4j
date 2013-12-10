package com.danilov.bool4j.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Util {

	public static final void Log(final String message) {
		System.out.println(message);
	}
	
	public static final void LogNoLn(final String message) {
		System.out.print(message);
	}
	
	public static <A, B> Map<A, B> cloneMap(final Map<A, B> map) {
		Map<A, B> cloned = new HashMap<A, B>();
		Set<A> keySet = map.keySet();
		for (A key : keySet) {
			cloned.put(key, map.get(key));
		}
		return cloned;
	}
	
}
