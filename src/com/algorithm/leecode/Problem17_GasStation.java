package com.algorithm.leecode;

/**
 * 一岛存在N个加油站组成一个环，假设在第i个加油站可加油gas[i]，而去第（i+1）个加油站要消耗cost[i]的油，求从哪个加油站出发可以环岛一周，如果没有返回-1
 * 思路：全程加的油要不小于消耗的油，如果到达某站发现gasTotal小于0则该起点到i之间都不能为起点。
 * 
 * @author wangbo Created on 2017年9月5日 下午8:39:30
 */
public class Problem17_GasStation {
	public static int gasStation(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0)
			return -1;
		int gasTotal = 0, start = 0, sum = 0;
		for (int i = 0; i < gas.length; i++) {
			gasTotal += gas[i] - cost[i];
			sum += gas[i] - cost[i];
			if (gasTotal < 0) {
				start = i + 1;
				gasTotal = 0;
			}
		}
		if (sum < 0)
			return -1;
		return start;
	}
}
