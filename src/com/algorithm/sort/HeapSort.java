package com.algorithm.sort;

public class HeapSort {
	public static void heapSort(int[] array) {
		if (array == null || array.length == 0)
			return;
		int lastIndex = array.length - 1;
		// ���������
		buildMaxHeap(array, lastIndex);
		while (lastIndex > 0) {
			swap(array, 0, lastIndex);
			if (--lastIndex == 0)// ֻʣһ��Ԫ�أ��Ͳ��õ������ˣ��������
				break;
			adjustHeap(array, 0, lastIndex);
		}
	}

	public static void buildMaxHeap(int[] array, int lastIndex) {
		// �����һ��Ԫ�صĸ��ڵ㿪ʼ���е�����һֱ���������ڵ����
		int j = (lastIndex - 1) / 2;
		while (j > 0) {
			adjustHeap(array, j, lastIndex);
			j--;
		}
	}

	public static void adjustHeap(int[] array, int rootIndex, int lastIndex) {
		int biggerIndex = rootIndex;
		int leftChildIndex = 2 * rootIndex + 1;
		int rightChildIndex = 2 * rootIndex + 2;
		// ����Һ��Ӵ��ڣ�������һ������
		if (rightChildIndex < lastIndex) {
			if (array[rightChildIndex] > array[rootIndex] || array[leftChildIndex] > array[rootIndex]) {
				// ���ӽڵ�����Ԫ���±긳ֵ��biggerIndex
				biggerIndex = array[rightChildIndex] > array[leftChildIndex] ? rightChildIndex : leftChildIndex;
			}
		} else if (leftChildIndex <= lastIndex) {
			if (array[leftChildIndex] > array[rootIndex])
				biggerIndex = leftChildIndex;
		}
		if (biggerIndex != rootIndex) {
			swap(array, biggerIndex, rootIndex);
			adjustHeap(array, biggerIndex, lastIndex);
		}
	}

	public static void swap(int[] array, int biggerIndex, int rootIndex) {
		int temp = array[rootIndex];
		array[rootIndex] = array[biggerIndex];
		array[biggerIndex] = temp;
	}

}
