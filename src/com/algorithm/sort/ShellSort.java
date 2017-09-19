package com.algorithm.sort;

public class ShellSort {
	public static void shellSort(int[] array) {
		if (array == null || array.length == 0)
			return;
		int incre = array.length / 2;
		while (incre >= 1) {
			shellInsert(array, incre);
			incre /= 2;
		}
	}

	public static void shellInsert(int[] array, int incre) {
		int target, j;
		for (int i = incre; i < array.length; i++) {
			j = i - incre;
			target = array[i];
			while (j >= 0 && array[j] > target) {
				array[j + incre] = array[j];
				j -= incre;
			}
			if (j != i - incre)
				array[j + incre] = target;
		}
	}
}
