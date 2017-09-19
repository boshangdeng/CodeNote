package com.algorithm.sort;

public class Sort {

	public static void main(String[] args) {
		int a[] = { 10, 5, 8, 2, 3, 7, 9, 6, 1, 4 };
		// BubbleSort.bubbleSort(a);
		// QuickSort.sort(a);
		// InsertSort.insertSort(a);
		// ShellSort.shellSort(a);
		// SelectSort.selectSort(a);
		// HeapSort.heapSort(a);
		// MergeSort.mergeSort(a);
		// RadixSort.radixSort(a);
		for (int i = 0; i < a.length - 1; i++)
			System.out.print(a[i] + "\t");
		System.out.println(a[a.length - 1]);
	}

}
