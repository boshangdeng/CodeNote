package com.algorithm.leecode;

/**
 * 单链表插入排序
 * 
 * @author wangbo Created on 2017年8月29日 上午2:43:02
 */
public class Problem5_InsertSort {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode insertSort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode left = head;
		ListNode lPre = null, rPre = head;
		ListNode right = rPre.next;
		while (right != null) {
			if (right.val < left.val) {
				rPre.next = right.next;
				right.next = head;
				head = right;
			} else {
				lPre = left;
				left = lPre.next;
				while (left != right && left.val < right.val) {
					lPre = left;
					left = left.next;
				}
				if (left == right) {
					rPre = right;
					right = right.next;
				} else {
					rPre.next = right.next;
					lPre.next = right;
					right.next = left;
				}
			}
			left = head;
			right = rPre.next;
		}
		return head;
	}

}
