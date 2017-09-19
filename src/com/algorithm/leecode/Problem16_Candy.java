package com.algorithm.leecode;

import java.util.Arrays;

/**
 * 根据孩子分数发糖，每个孩子至少发一颗，且相邻孩子分数高的孩子比分数低的孩子塘多，求至少需要多少糖
 * 
 * @author wangbo Created on 2017年9月5日 下午8:36:58
 */
public class Problem16_Candy {
	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int[] count = new int[ratings.length];
		Arrays.fill(count, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				count[i] = count[i - 1] + 1;
		}

		int sum = 0;
		for (int j = ratings.length - 1; j > 0; j--) {
			sum += count[j];
			if (ratings[j] < ratings[j - 1] && count[j] >= count[j - 1])
				count[j - 1] = count[j] + 1;
		}
		return sum + count[0];
	}
}
