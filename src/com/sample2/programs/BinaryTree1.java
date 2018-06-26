import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree1 {

	static Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	BinaryTree1() {
		root = null;
	}

	public void insert(int data) {
		root = insertRec(root, data);
	}

	public Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.data) {
			root.left = insertRec(root.left, key);
		} else {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	public void printPreOrder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	public void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.println(root.data);
			printInOrder(root.right);
		}
	}

	public void printPostOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			printInOrder(root.right);
			System.out.println(root.data);
		}
	}

	public void printLevelOrder() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.println(tempNode.data);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);

		}
	}

	public Node search(Node node, int searchKey) {
		if (node == null || node.data == searchKey)
			return node;
		if (node.data > searchKey)
			return search(node.left, searchKey);
		return search(node.right, searchKey);

	}

	public void practiceBinaryTreeTrigger() {
		BinaryTree1 tree = new BinaryTree1();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Printing binary tree in-order traversal data");
		// print inorder traversal of the BST
		tree.printInOrder(tree.root);

		Node resultNode = tree.search(tree.root, 70);
		System.out.println("Search value is : " + resultNode.data);
	}
}
