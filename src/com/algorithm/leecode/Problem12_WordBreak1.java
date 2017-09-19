package com.algorithm.leecode;

import java.util.Set;

/**
 * 判断给定字符串是否能由给定字符数组摘要组成
 * 
 * @author wangbo Created on 2017年9月3日 上午12:34:55
 */
public class Problem12_WordBreak1 {
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return false;
		int len = s.length();
		boolean[] arrays = new boolean[len + 1];
		arrays[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (arrays[j] && dict.contains(s.substring(j, i))) {
					arrays[i] = true;
					break;
				}
			}
		}
		return arrays[len];
	}
}
