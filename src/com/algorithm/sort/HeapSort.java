package com.algorithm.sort;

public class HeapSort {
	public static void heapSort(int[] array) {
		if (array == null || array.length == 0)
			return;
		int lastIndex = array.length - 1;
		// 建立大根堆
		buildMaxHeap(array, lastIndex);
		while (lastIndex > 0) {
			swap(array, 0, lastIndex);
			if (--lastIndex == 0)// 只剩一个元素，就不用调整堆了，排序结束
				break;
			adjustHeap(array, 0, lastIndex);
		}
	}

	public static void buildMaxHeap(int[] array, int lastIndex) {
		// 从最后一个元素的父节点开始进行调整，一直调整到根节点结束
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
		// 如果右孩子存在，则左孩子一定存在
		if (rightChildIndex < lastIndex) {
			if (array[rightChildIndex] > array[rootIndex] || array[leftChildIndex] > array[rootIndex]) {
				// 将子节点更大的元素下标赋值给biggerIndex
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
