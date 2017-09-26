package com.algorithm.examination.recursive;

import java.util.Scanner;

/**
 * �����е����ԣ�����һ����N������N�ĸ�λ����ɵ���M,����N%M==0��M!=N ȫ���У������ƽⷨ
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
	 * �ݹ��ַ���ȫ���У���һ���ַ���ÿ���ַ��ֱ�����������ַ��������ݹ����
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
				swap(data, begin, i);// ע�⣺i��begin��ʼ������begin+1��ʼ������ΪҪ���������������
				permutate(data, begin + 1, num);
				swap(data, begin, i);// ���ݣ����֮ǰǰ׺
			}
		}
	}
	//ȥ�ص�ȫ���о��Ǵӵ�һ���ַ���ÿ���ַ��ֱ�����������ظ����ֵ��ַ�������
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
