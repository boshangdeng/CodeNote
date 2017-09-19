package com.algorithm.sort;

public class QuickSort {
	public static void sort(int[] array) {
		if (array == null || array.length == 0)
			return;
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] array, int left, int right) {
		if (left >= right)
			return;
		int pivotPos = partition(array, left, right);
		quickSort(array, left, pivotPos - 1);
		quickSort(array, pivotPos + 1, right);
	}

	public static int partition(int[] array, int left, int right) {
		int pivotKey = array[left];
		while (left < right) {
			while (left < right && array[right] >= pivotKey)
				right--;
			array[left] = array[right];
			while (left < right && array[left] <= pivotKey)
				left++;
			array[right] = array[left];
		}
		array[left] = pivotKey;
		return left;
	}
}
