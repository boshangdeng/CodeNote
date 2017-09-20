package com.algorithm.leecode;

/**
 * 检测链表是否有环（快慢指针）
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
