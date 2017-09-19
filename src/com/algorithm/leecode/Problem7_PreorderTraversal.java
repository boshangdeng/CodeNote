package com.algorithm.leecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ����ǰ�������ջʵ��
 * 
 * @author wangbo Created on 2017��8��29�� ����10:03:37
 */
public class Problem7_PreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			list.add(temp.val);
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
		return list;
	}
}
