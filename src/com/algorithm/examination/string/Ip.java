package com.algorithm.examination.string;

import java.util.ArrayList;

/**
 * 给定字符串（数字组成），判断可能的ip地址并输出 思路：回溯
 * 
 * @author wangbo
 *
 */
public class Ip {

	public ArrayList<String> getIps(String s) {
		ArrayList<String> ips = new ArrayList<>();
		if (s == null || s.length() == 0)
			return ips;
		backTrace(ips, s, "", 0, 0);
		return ips;
	}

	private void backTrace(ArrayList<String> ips, String s, String current, int i, int p) {
		// 判断是否完成一次合法IP地址拼接
		if (i == 4) {
			ips.add(current);
			return;
		}
		// 枚举当前段的长度
		for (int j = 1; j <= 3; j++) {
			// 三位数不超过255
			if (j == 3 && (p + j < s.length()) && Integer.parseInt(s.substring(p, p + j)) > 255)
				continue;
			// 每段首位不能为0
			if (s.charAt(p) == '0')
				continue;
			// 每段至少1位，至多三位
			if (s.length() - p - j < 4 - i - 1 || (s.length() - p - j > 3 * (4 - i - 1)))
				continue;
			// 判断是否需要分隔符
			if (i > 0)
				current += ".";
			current += s.substring(p, p + j);
			backTrace(ips, s, current, i + 1, p + j);
			// 还原
			current = current.substring(0, current.length() - j);
			if (i > 0)
				current = current.substring(0, current.length() - 1);
		}

	}
}
