package com.algorithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
	@SuppressWarnings("null")
	public static void radixSort(int[] array) {
		if (array == null && array.length == 0)
			return;
		int maxBit = getMaxBit(array);
		for (int i = 1; i <= maxBit; i++) {
			List<List<Integer>> buf = distribute(array, i); // ����
			collecte(array, buf); // �ռ�
		}
	}

	public static List<List<Integer>> distribute(int[] array, int iBit) {
		List<List<Integer>> buf = new ArrayList<List<Integer>>();
		for (int j = 0; j < 10; j++) {
			buf.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < array.length; i++) {
			buf.get(getNBit(array[i], iBit)).add(array[i]);
		}
		return buf;
	}

	public static void collecte(int[] array, List<List<Integer>> buf) {
		int k = 0;
		for (List<Integer> bucket : buf) {
			for (int ele : bucket) {
				array[k++] = ele;
			}
		}

	}

	public static int getMaxBit(int[] array) {
		int max = Integer.MIN_VALUE;
		int len;
		for (int ele : array) {
			len = (ele + "").length();
			if (len > max)
				max = len;
		}
		return max;
	}

	/**
	 * ��ȡx�ĵ�nλ
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public static int getNBit(int x, int n) {
		String sx = x + "";
		if (sx.length() < n)
			return 0;
		else
			return sx.charAt(sx.length() - n) - '0';
	}
}
