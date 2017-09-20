package com.algorithm.leecode;

/**
 * ��һ���������ػ�����㣬���û�л��ͷ���null
 * 
 * @author wangbo 
 * ˼·��1��ʹ�ÿ���ָ��ȷ���Ƿ��л�������л������������㡣�޻�������null��
 *       2����ָ��ֱ��������ʼ��������������ÿ����һ�����ٴ�������Ϊ�����
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
