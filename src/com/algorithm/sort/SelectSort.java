package com.algorithm.sort;

public class SelectSort {
	public static void selectSort(int[] array) {
		int minIndex, temp;
		for (int i = 0; i < array.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex])
					minIndex = j;
			}
			if (minIndex != i) {
				temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
		}
	}
}
