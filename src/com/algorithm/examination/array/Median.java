package com.algorithm.examination.array;

import java.util.Scanner;

/**
 * Я�̱�������λ���������������飬��ϲ��������λ��
 * 
 * @author wangbo
 *
 */
public class Median {

	public static void madian(String[] args) {
		Scanner in = new Scanner(System.in);
		// ����a����
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		//����b����
		int m = in.nextInt();
		int[] b = new int[m];
		for (int j = 0; j < m; j++)
			b[j] = in.nextInt();
		//�鲢����c
		int[] c = new int[m + n];
		int i = 0, j = 0, p = 0;
		while (i < n && j < m) {
			if (a[i] < b[j])
				c[p++] = a[i++];
			else if (a[i] == b[j]) {
				c[p++] = a[i++];
				j++;
			} else {
				c[p++] = b[j++];
			}
		}
		while (i < n) {
			c[p++] = a[i++];
		}
		while (j < m) {
			c[p++] = a[j++];
		}
		//����λ�������
		if (p % 2 == 0)
			System.out.println((a[p / 2 - 1] + a[p / 2]) / 2.0);
		else
			System.out.println(a[p / 2]);
	}

}
