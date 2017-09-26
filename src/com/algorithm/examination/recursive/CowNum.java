package com.algorithm.examination.recursive;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 招银笔试：10头母牛，一头母牛每年年初生两头母牛，第一年死两头母牛，后面成2倍增长，求第100年有多少头母牛。例如第2年有28=10*2+10-2头母牛
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
