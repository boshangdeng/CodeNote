package com.algorithm.leecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * �������������
 * 
 * @author wangbo Created on 2017��8��29�� ����1:56:46
 */

public class Problem6_PostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if (root == null)
			return arrayList;
		TreeNode curNode = root;
		TreeNode visitedNode = null;// �շ��ʽڵ�
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (curNode != null || !stack.isEmpty()) {
			if (curNode != null) {
				stack.push(curNode);
				curNode = curNode.left;
			} else {
				curNode = stack.peek();
				curNode = curNode.right;
				if (curNode != null && curNode != visitedNode) {
					stack.push(curNode);
					curNode = curNode.left;
				} else {
					curNode = stack.pop();
					arrayList.add(curNode.val);
					visitedNode = curNode;
					curNode = null;
				}
			}
		}
		return arrayList;
	}
}
