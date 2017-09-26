package com.algorithm.examination.recursive;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * �������ԣ�10ͷĸţ��һͷĸţÿ���������ͷĸţ����һ������ͷĸţ�������2�����������100���ж���ͷĸţ�������2����28=10*2+10-2ͷĸţ
 * 
 * @author wangbo
 *
 */
public class CowNum {
	private static BigInteger sum = BigInteger.ZERO;

	public static BigInteger calculateCows(int n) {
		if (n == 1)
			return BigInteger.valueOf(10);
		return calculateCows(n - 1).multiply(BigInteger.valueOf(3)).subtract(BigInteger.valueOf(2 * (n - 1)));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		sum = calculateCows(n);
		System.out.println(sum.toString());
	}
}
