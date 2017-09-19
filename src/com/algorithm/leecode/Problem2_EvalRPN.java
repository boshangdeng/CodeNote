package com.algorithm.leecode;

import java.util.Stack;

/**
 * 逆波兰式
 * 思路：遇到整数入栈，遇到操作数出栈两次并运算，然后结果入栈
 * @author wangbo Created on 2017年8月28日 下午9:23:04
 */
public class Problem2_EvalRPN {
	public static int evalPRN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			try {
				int num = Integer.parseInt(tokens[i]);
				stack.add(num);
			} catch (NumberFormatException e) {
				int a = stack.pop();
				int b = stack.pop();
				stack.add(get(a, b, tokens[i]));
			}
		}
		return stack.pop();
	}

	public static int get(int a, int b, String operator) {
		switch (operator) {
		case "+":
			return b + a;
		case "-":
			return b - a;
		case "*":
			return b * a;
		case "/":
			return b / a;
		default:
			return 0;
		}
	}
}
