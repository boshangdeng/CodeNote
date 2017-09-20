package com.algorithm.leecode;

/**
 * 最小回文分割数 动态规划：    
 * dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。
 * 分几种情况：
 * 1.初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，dp[i] = 0(表示不需要分割)；否则，dp[i] = * i（表示至多分割i次）;  
 * 2.对于任意大于1的i，如果s.substring(j,i+1)(j<=i,即遍历i之前的每个子串)是回文时，dp[i] = * min(dp[i], dp[j-1]+1);
 * 3.如果s.substring(j,i+1)(j<=i)不是回文时，dp[i] = * min(dp[i],dp[j-1]+i+1-j);
 * 
 * @author wangbo
 *
 */
public class Problem19_MinCut {

	public int minCut(String s) {
		int[] dp = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
			if (dp[i] == 0) {
				continue;
			}
			for (int j = 1; j <= i; j++) {
				if (isPalindrome(s.substring(j, i + 1))) {
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				} else {
					dp[i] = Math.min(dp[i], dp[j - 1] + i - j + 1);
				}
			}
		}
		return dp[s.length() - 1];
	}

	public static boolean isPalindrome(String s) {
		if (s == null)
			return false;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}
}
