package com.algorithm.examination.combination;

import java.util.Scanner;

/**
 * �Ա������⣺N��ͬѧ�μӱ���������ڵĵı�����������οɲ��У� ˼·����̬�滮��dp[i][j]��ʾj������i�����Σ��������������
 * 1��û�в��е��������dp[i][i]=i! 
 * 2��ȫ�����У���dp[1][j]=1
 * 3��״̬ת�Ʒ���dp[i][j]=i*dp[i-1][j-1]+i*dp[i][j-1]��j>i>1��,��j-1�����źú����һ���ˣ������������һ�Ǽ������һ���µ����Σ�ѡ������յ����룬���Ǻ�ĳһ����ĳ��������
 * 
 * @author wangbo Created on 2017��9��23�� ����1:49:09
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
	 * ����׳�������n! = n * (n-1) * ... * 2 * 1
	 * 
	 * @param n
	 * @return
	 */
	private static long factorial(int n) {
		return (n > 1) ? n * factorial(n - 1) : 1;
	}

	/**
	 * ��������������A(n, m) = n!/(n-m)!
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static long arrangement(int n, int m) {
		return (n >= m) ? factorial(n) / factorial(n - m) : 0;
	}

	/**
	 * �������������C(n, m) = n!/((n-m)! * m!)
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static long combination(int n, int m) {
		return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
	}
}
