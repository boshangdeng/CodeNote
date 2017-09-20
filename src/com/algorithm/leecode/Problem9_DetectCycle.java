package com.algorithm.leecode;

/**
 * 给一个链表，返回环的起点，如果没有环就返回null
 * 
 * @author wangbo 
 * 思路：1、使用快慢指针确定是否有环。如果有环，返回相遇点。无环，返回null。
 *       2、两指针分别从链表起始点和相遇点出发，每次走一步，再次相遇即为环起点
 */
public class Problem9_DetectCycle {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null)
			return null;
		ListNode front = fast;
		ListNode post = head;
		while (front != post) {
			front = front.next;
			post = post.next;
		}
		return front;
	}
}
