package com.algorithm.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的最小深度
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
	 * 递归求解
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
	 * 非递归求解（队列）,广度优先搜索
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
		// 层次遍历
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
			// 遍历完一层就加一
			level++;
		}
		return level;
	}
}
