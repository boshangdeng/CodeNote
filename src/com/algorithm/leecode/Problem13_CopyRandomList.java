package com.algorithm.leecode;

/**
 * �������
 * 
 * @author wangbo Created on 2017��9��3�� ����2:27:20
 */
public class Problem13_CopyRandomList {
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		// 1�����ƽڵ�
		RandomListNode curRadomNode = head;
		while (curRadomNode != null) {
			RandomListNode copyNode = new RandomListNode(curRadomNode.label);
			copyNode.next = curRadomNode.next;
			curRadomNode.next = copyNode;
			curRadomNode = copyNode.next;
		}
		// 2������random
		curRadomNode = head;
		while (curRadomNode != null) {
			if (curRadomNode.random != null)
				curRadomNode.next.random = curRadomNode.random.next;
			else
				curRadomNode.next.random = null;
			curRadomNode = curRadomNode.next.next;
		}
		// 3�����
		curRadomNode = head;
		RandomListNode newHead = head.next;
		RandomListNode newCurRadomNode = newHead;
		while (curRadomNode != null) {
			curRadomNode.next = newCurRadomNode.next;
			curRadomNode = curRadomNode.next;
			if (curRadomNode != null) {
				newCurRadomNode.next = curRadomNode.next;
				newCurRadomNode = curRadomNode.next;
			}
		}
		return newHead;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}
};