package com.algorithm.examination.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 小米笔试题之密码破译：1-a,2-b,...,26-z;输入一串数字，判断所有可能的密码 
 * 思路：深度优先搜索
 * 
 * @author wangbo Created on 2017年9月19日 上午8:31:29
 */
public class XiaoMiBreakCode {
	final static HashMap<String, String> code = new HashMap<>();

	public static void main(String[] args) {
		// 输入
		Scanner in = new Scanner(System.in);
		ArrayList<String> numbers = new ArrayList<String>();
		while (in.hasNext()) {
			numbers.add(in.nextLine());
		}
		// 初始化编码
		for (int j = 1; j <= 26; j++) {
			code.put(String.valueOf(j), String.valueOf(((char) (96 + j))));
		}
		HashMap<String, ArrayList<String>> results = new HashMap<String, ArrayList<String>>();
		// 解码
		for (int m = 0; m < numbers.size(); m++) {
			String number = numbers.get(m);
			dfs(results, number, "", 0);
		}
		for (String key : results.keySet()) {
			ArrayList<String> list = results.get(key);
			String result = key + ":";
			for (int n = 0; n < list.size(); n++) {
				result += list.get(n) + " ";
			}
			result = result.trim();
			System.out.println(result);
			result = "";
		}
	}

	public static void dfs(HashMap<String, ArrayList<String>> results, String number, String current, int p) {
		if (p == number.length()) {
			if (results.containsKey(number)) {
				results.get(number).add(current);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(current);
				results.put(number, list);
			}
			return;
		}
		String temp = current;
		if (p + 1 <= number.length() && check(number.substring(p, p + 1))) {
			temp += code.get(number.substring(p, p + 1));
			dfs(results, number, temp, p + 1);
		}
		temp = current;
		if (p + 2 <= number.length() && check(number.substring(p, p + 2))) {
			temp += code.get(number.substring(p, p + 2));
			dfs(results, number, temp, p + 2);
		}
	}

	public static boolean check(String s) {
		if (code.containsKey(s))
			return true;
		else
			return false;
	}
}