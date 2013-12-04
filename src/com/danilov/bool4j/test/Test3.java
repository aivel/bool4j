package com.danilov.bool4j.test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.danilov.bool4j.util.Util;
import com.danilov.bool4j.util.VariablesSet;

public class Test3 implements ITest {

	@Override
	public void test() {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("c");
		set.add("b");
		VariablesSet varSet = new VariablesSet(set);
		List<String> vv = varSet.getKeySet();
		for (String key : vv) {
			Util.LogNoLn(key + " ");
		}
		Util.Log("");
		while(varSet.notEnd()) {
			Map<String, Boolean> m = varSet.get();
			for (String key : vv) {
				Boolean var = m.get(key);
				String s;
				if (var) {
					s = "1";
				} else {
					s = "0";
				}
				Util.LogNoLn(s + " ");
			}
			Util.Log("");
			varSet.moveToNext();
		}
	}

}
