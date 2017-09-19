package com.algorithm.sort;

public class MergeSort {
	public static void mergeSort(int[] array) {
		mSort(array, 0, array.length - 1);
	}

	public static void mSort(int[] array, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;

		mSort(array, left, mid); // �ݹ��������
		mSort(array, mid + 1, right); // �ݹ������ұ�
		merge(array, left, mid, right); // �ϲ�
	}

	public static void merge(int[] array, int left, int mid, int right) {
		int[] temp = new int[right - left + 1]; // �м�����

		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = array[i++];
		}

		while (j <= right) {
			temp[k++] = array[j++];
		}

		for (int p = 0; p < temp.length; p++) {
			array[left + p] = temp[p];
		}

	}
}
