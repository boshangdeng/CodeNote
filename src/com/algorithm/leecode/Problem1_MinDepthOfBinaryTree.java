package com.algorithm.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �����������С���
 * 
 * @author wb
 *
 */
public class Problem1_MinDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * �ݹ����
	 *
	 * @param root
	 * @return
	 */
	public static int run_recursive(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null) {
			return run_recursive(root.right) + 1;
		}
		if (root.right == null) {
			return run_recursive(root.left) + 1;
		}
		int lMinDep = run_recursive(root.left);
		int rMinDep = run_recursive(root.right);
		if (lMinDep < rMinDep)
			return lMinDep + 1;
		else
			return rMinDep + 1;
	}

	/**
	 * �ǵݹ���⣨���У�,�����������
	 * 
	 * @param root
	 * @return
	 */
	public static int run_inrecursive(TreeNode root) {
		if (root == null)
			return 0;
		Queue queue = new LinkedList();
		queue.add(root);
		int level = 1;
		// ��α���
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = (TreeNode) queue.poll();
				if (node.left == null && node.right == null)
					return level;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}

			}
			// ������һ��ͼ�һ
			level++;
		}
		return level;
	}
}
