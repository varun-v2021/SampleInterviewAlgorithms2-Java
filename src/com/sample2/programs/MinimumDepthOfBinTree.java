package com.sample2.programs;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class MinimumDepthOfBinTree {

	Node root;

	int minimumDepth() {
		return minimumDepth(root);
	}

	public int minimumDepth(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		if (node.left == null)
			return minimumDepth(node.right) + 1;
		if (node.right == null)
			return minimumDepth(node.left) + 1;
		return Math.min(minimumDepth(node.left), minimumDepth(node.right)) + 1;
	}

	public static void main3(String[] args) {
		MinimumDepthOfBinTree tree = new MinimumDepthOfBinTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The minimum depth of " + "binary tree is : " + tree.minimumDepth());

	}

}
