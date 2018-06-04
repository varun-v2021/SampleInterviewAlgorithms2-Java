package com.sample2.programs;

/*
 * For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child

The idea is to keep trace of four paths and pick up the max one in the end.
An important thing to note is, root of every subtree need to return maximum path sum 
such that at most one child of root is involved. This is needed for parent function call.
In below code, this sum is stored in ‘max_single’ and returned by the recursive function.
 * */

class Res {
	int val;
}

public class MaxPathSumInBinTree {

	Node root;

	public int findMaxUtil(Node node, Res res) {
		if (node == null)
			return 0;
		// l and r store maximum path sum going through left and
		// right child of root respectively
		int l = findMaxUtil(node.left, res);
		int r = findMaxUtil(node.right, res);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + node.data, node.data);

		// Max Top represents the sum when the Node under
		// consideration is the root of the maxsum path and no
		// ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + node.data);

		// Store the Maximum Result.
		res.val = Math.max(res.val, max_top);

		/*
		 * 1} "max_top" = When the node is "topmost", meaning both his subtrees
		 * are part of the path. If this is the best path found yet, he stores
		 * it in "res" variable.
		 * 
		 * 2) "max_single" = When the node is not "topmost", meaning the path
		 * leads through his parent, and he returns the better subtree + his own
		 * value.
		 * 
		 */
		return max_single;

	}

	public int findMaxSum(Node node) {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		findMaxUtil(node, res);
		return res.val;
	}

	int findMaxSum() {
		return findMaxSum(root);
	}

	public static void main4(String[] args) {
		MaxPathSumInBinTree tree = new MaxPathSumInBinTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(-25);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(4);
		System.out.println("maximum path sum is : " + tree.findMaxSum());
	}
}
