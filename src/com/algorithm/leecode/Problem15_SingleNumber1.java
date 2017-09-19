package com.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

public class Problem15_SingleNumber1 {
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0)
			return -1;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			String key = String.valueOf(A[i]);
			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}
		for (String e : map.keySet()) {
			if (map.get(e) == 1)
				return Integer.valueOf(e);
		}
		return -1;
	}
}
