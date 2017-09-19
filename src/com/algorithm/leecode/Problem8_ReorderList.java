package com.algorithm.leecode;

/**
 * L 0→L 1→…→L n-1→L n to L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 快慢指针找到链表中间节点，采用前插法将后半部分链表反转，合并前后子链表
 * 
 * @author wangbo Created on 2017年8月29日 下午11:50:46
 */
public class Problem8_ReorderList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode reorderList(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode preNode = slow.next;
		if (head != null && head.next != null) {
			ListNode nextNode = preNode.next;
			while (nextNode != null) {
				preNode.next = nextNode.next;
				nextNode.next = slow.next;
				slow.next = nextNode;
				nextNode = preNode.next;
			}
		}
		return merge(head, slow);
	}

	public static ListNode merge(ListNode head, ListNode slow) {
		ListNode p = head;
		ListNode q = slow.next;
		while (p != null && q != null) {
			slow.next = q.next;
			q.next = p.next;
			p.next = q;
			q = slow.next;
			p = p.next.next;
		}
		return p;
	}
}
