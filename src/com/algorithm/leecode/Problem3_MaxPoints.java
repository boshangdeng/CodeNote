package com.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * һƷ����n���㣬���ƽ���ڰ���������ֱ�� ˼·��ѡ��һ��A����ʣ�µ���A���������������1���ظ�2����A��X����ͬ3�������������ͬһֱ�߼�б����ͬ��
 * 
 * @author wangbo Created on 2017��8��28�� ����10:32:43
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
			int dup = 1;// �ظ�
			int vel = 0;// ��x�ᴹֱ
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
