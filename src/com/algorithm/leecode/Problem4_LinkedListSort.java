package com.algorithm.leecode;

/**
 * ������������ʱ�临�Ӷ�O(nlogn)���ռ临�Ӷ�O(1) ˼·���鲢����
 * 
 * @author wangbo Created on 2017��8��28�� ����11:37:03
 */
public class Problem4_LinkedListSort {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode sortListMerge(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMid(head);
		ListNode right = sortListMerge(mid.next);
		mid.next = null;
		ListNode left = sortListMerge(head);
		return mergeSort(left, right);
	}

	public static ListNode mergeSort(ListNode left, ListNode right) {
		if (left == null)
			return right;
		if (right == null)
			return left;
		ListNode head = null;
		if (left.val <= right.val) {
			head = left;
			left = left.next;
		} else {
			head = right;
			right = right.next;
		}
		ListNode temp = head;
		while (left != null && right != null) {
			if (left.val <= right.val) {
				temp.next = left;
				left = left.next;
			} else {
				temp.next = right;
				right = right.next;
			}
			temp = temp.next;
		}
		if (left != null) {
			temp.next = left;
		}
		if (right != null) {
			temp.next = right;
		}
		return head;
	}

	public static ListNode getMid(ListNode head) {
		ListNode temp = head.next;
		ListNode mid = head;
		while (temp != null && temp.next != null) {
			mid = mid.next;
			temp = temp.next.next;
		}
		return mid;
	}
}
