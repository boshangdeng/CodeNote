package com.algorithm.leecode;

/**
 * ��������Ƿ��л�������ָ�룩
 * 
 * @author wangbo
 *
 */
public class Problem10_HasCycle {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
		}
		if (fast == null || fast.next == null)
			return false;
		return true;
	}
}
