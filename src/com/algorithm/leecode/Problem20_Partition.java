package com.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * 字符串回文划分：回溯递归
 * @author wangbo
 * Created on 2017年10月26日 下午12:02:29
 */
public class Problem20_Partition {
	private ArrayList<ArrayList<String>> solutions;

	private ArrayList<String> current;

	public ArrayList<ArrayList<String>> partition(String s) {
		solutions = new ArrayList<ArrayList<String>>();
		current = new ArrayList<>();
		findPalidrome(s, 0);
		return solutions;
	}

	public void findPalidrome(String s, int left) {
		if (left >= s.length() && current.size() > 0) {
			ArrayList<String> temp = new ArrayList<>(Arrays.asList(new String[current.size()]));
			Collections.copy(temp, current); // 深拷贝
			solutions.add(temp);
			return;
		}

		for (int right = left; right < s.length(); right++) {
			if (isPalindrome(s, left, right)) {
				if (left == right)
					current.add(Character.toString(s.charAt(left)));
				else
					current.add(s.substring(left, right + 1));
				findPalidrome(s, right + 1);
				//回溯
				current.remove(current.size() - 1);
			}
		}
	}

	/**
	 * 判断字符串是否为回文
	 * 
	 * @param s
	 * @param left
	 * @param right
	 * @return
	 */
	public boolean isPalindrome(String s, int left, int right) {
		if (left == right)
			return true;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		Problem20_Partition p = new Problem20_Partition();
		p.partition("bb");
	}
}
