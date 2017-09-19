package com.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 一品面有n个点，求该平面内包含点最多的直线 思路：选择一点A，则剩下点与A存在三种情况——1、重复2、与A点X轴相同3、其它情况，在同一直线即斜率相同。
 * 
 * @author wangbo Created on 2017年8月28日 下午10:32:43
 */
public class Problem3_MaxPoints {
	class Point {
		int x;
		int y;

		public Point() {
			x = 0;
			y = 0;
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int maxPoints(Point[] points) {
		int n = points.length;
		if (n < 2)
			return n;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			int dup = 1;// 重复
			int vel = 0;// 与x轴垂直
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						dup++;
					} else {
						vel++;
					}
				} else {
					double k = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
					if (map.get(k) == null)
						map.put(k, 1);
					else
						map.put(k, map.get(k) + 1);
				}
			}
			int max = vel;
			for (double k : map.keySet()) {
				max = Math.max(max, map.get(k));
			}
			ret = Math.max(ret, max + dup);
		}
		return ret;
	}
}
