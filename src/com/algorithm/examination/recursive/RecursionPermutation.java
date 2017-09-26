package com.algorithm.examination.recursive;

import java.util.Scanner;

/**
 * 网易有道笔试：输入一个数N，求由N的各位数组成的数M,满足N%M==0，M!=N 全排列，暴力破解法
 * 
 * @author wangbo
 *
 */
public class RecursionPermutation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String num = String.valueOf(n);
		char[] data = num.toCharArray();
		RecursionPermutation.permutate(data, 0, n);
	}

	/**
	 * 递归字符串全排列：第一个字符起每个字符分别与它后面的字符交换，递归调用
	 * 
	 * @param data
	 * @param begin
	 * @param num
	 */
	public static void permutate(char[] data, int begin, int num) {
		int length = data.length;
		if (begin == length) {
			if (data[0] == '0')
				return;
			int m = Integer.parseInt(String.valueOf(data));
			if (m != 0 && m != num && num % m == 0)
				System.out.println(String.valueOf(data));
		}
		for (int i = begin; i < length; i++) {
			if (isUnique(data, begin, i)) {
				swap(data, begin, i);// 注意：i从begin开始而不是begin+1开始，是因为要考虑自身这种情况
				permutate(data, begin + 1, num);
				swap(data, begin, i);// 回溯，变回之前前缀
			}
		}
	}
	//去重的全排列就是从第一个字符起每个字符分别与它后面非重复出现的字符交换。
	public static boolean isUnique(char[] data, int begin, int end) {
		for (int i = begin; i < end; i++)
			if (data[i] == data[end])
				return false;
		return true;
	}

	public static void swap(char[] data, int left, int right) {
		if (left == right)
			return;
		char temp = data[left];
		data[left] = data[right];
		data[right] = temp;
	}
}
