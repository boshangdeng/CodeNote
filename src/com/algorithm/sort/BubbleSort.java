package com.algorithm.sort;

public class BubbleSort {
	public static void bubbleSort(int[] array) {
		if (array == null || array.length == 0)
			return;
		int temp;
		boolean flag = true;
		for (int i = 0; i < array.length - 1 && flag; i++) {
			flag = false;
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					flag = true;
				}
			}
		}
	}
}
