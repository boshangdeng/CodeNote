package com.algorithm.examination.string;

public class Palindrome {
	/**
	 * 判断字符串是否为回文字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		if (s == null)
			return false;
		// 方法一：将字符串倒置后与原字符串比较
		// StringBuffer sb = new StringBuffer(s);
		// sb.reverse();
		// for (int i = 0; i < s.length(); i++) {
		// if (s.charAt(i) != sb.charAt(i))
		// return false;
		// }
		// 方法二：前后两指针比较
		int pre = 0;
		int end = s.length() - 1;
		while (pre <= end) {
			if (s.charAt(pre) != s.charAt(end))
				return false;
			pre++;
			end--;
		}
		return true;
	}
}
