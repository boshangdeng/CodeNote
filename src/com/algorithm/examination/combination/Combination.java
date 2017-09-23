package com.algorithm.examination.combination;

import java.util.Scanner;

/**
 * 猎豹笔试题：N个同学参加比赛，求存在的的比赛结果（名次可并列） 思路：动态规划，dp[i][j]表示j个人排i种名次，分三种情况——
 * 1、没有并列的情况，即dp[i][i]=i! 
 * 2、全部并列，即dp[1][j]=1
 * 3、状态转移方程dp[i][j]=i*dp[i-1][j-1]+i*dp[i][j-1]（j>i>1）,当j-1个人排好后加入一个人，分两种情况，一是加入的有一个新的名次，选择任意空档插入，二是和某一个或某几个并列
 * 
 * @author wangbo Created on 2017年9月23日 下午1:49:09
 */
public class Combination {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long[][] dp = new long[N + 1][N + 1];
		long[] results = new long[N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j)
					dp[i][j] = factorial(i);
				else if (i == 1)
					dp[i][j] = 1;
				else
					dp[i][j] = i * dp[i - 1][j - 1] + i * dp[i][j - 1];
			}
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j <= i; j++) {
				results[i] += dp[j][i];
			}
		}
		for (int i = 1; i < N + 1; i++)
			System.out.println(i + "-->" + results[i]);
	}

	/**
	 * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
	 * 
	 * @param n
	 * @return
	 */
	private static long factorial(int n) {
		return (n > 1) ? n * factorial(n - 1) : 1;
	}

	/**
	 * 计算排列数，即A(n, m) = n!/(n-m)!
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static long arrangement(int n, int m) {
		return (n >= m) ? factorial(n) / factorial(n - m) : 0;
	}

	/**
	 * 计算组合数，即C(n, m) = n!/((n-m)! * m!)
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static long combination(int n, int m) {
		return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
	}
}
