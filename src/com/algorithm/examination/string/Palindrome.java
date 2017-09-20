package com.algorithm.examination.string;

public class Palindrome {
	/**
	 * �ж��ַ����Ƿ�Ϊ�����ַ���
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		if (s == null)
			return false;
		// ����һ�����ַ������ú���ԭ�ַ����Ƚ�
		// StringBuffer sb = new StringBuffer(s);
		// sb.reverse();
		// for (int i = 0; i < s.length(); i++) {
		// if (s.charAt(i) != sb.charAt(i))
		// return false;
		// }
		// ��������ǰ����ָ��Ƚ�
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
