package com.algorithm.leecode;

/**
 * һ������N������վ���һ�����������ڵ�i������վ�ɼ���gas[i]����ȥ�ڣ�i+1��������վҪ����cost[i]���ͣ�����ĸ�����վ�������Ի���һ�ܣ����û�з���-1
 * ˼·��ȫ�̼ӵ���Ҫ��С�����ĵ��ͣ��������ĳվ����gasTotalС��0�����㵽i֮�䶼����Ϊ��㡣
 * 
 * @author wangbo Created on 2017��9��5�� ����8:39:30
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
