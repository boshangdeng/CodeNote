package com.algorithm.sort;

public class InsertSort {
	public static void insertSort(int[] array) {
		if (array == null || array.length == 0)
			return;
		int j;
		int target;
		for (int i = 1; i < array.length; i++) {
			j = i - 1;
			target = array[i];
			while (j >= 0 && target < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			if (j != i - 1)
				array[j + 1] = target;
		}
	}
}
