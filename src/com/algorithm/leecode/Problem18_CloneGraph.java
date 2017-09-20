package com.algorithm.leecode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 复制图：深度优先搜索+递归
 * 
 * @author wangbo
 *
 */
public class Problem18_CloneGraph {
	HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return node;
		if (map.containsKey(node.label))
			return map.get(node.label);
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(newNode.label, newNode);
		for (UndirectedGraphNode e : node.neighbors) {
			newNode.neighbors.add(cloneGraph(e));
		}
		return newNode;
	}
}

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
