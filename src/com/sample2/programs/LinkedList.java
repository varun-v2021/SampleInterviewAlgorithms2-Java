public class LinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void deleteNode(int key) {
		Node temp = head, prev = null;
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;
		prev.next = temp.next;
	}

	public boolean detectLoop() {
		Node slow_p = head;
		Node fast_p = head;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = head.next;
			fast_p = head.next.next;
			if (slow_p == fast_p)
				return true;
		}
		return false;
	}

	public Node reverseList(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	public void printList(Node root) {
		while (root != null) {
			System.out.println(root.data);
			root = root.next;
		}
	}

	public void practiceLLTrigger() {
		LinkedList ll = new LinkedList();
		ll.push(10);
		ll.push(20);
		ll.push(30);
		ll.push(40);
		ll.printList(head);
		System.out.println("Insertion pattern change ..");
		ll.head = new Node(50);
		ll.head.next = new Node(60);
		ll.head.next.next = new Node(70);
		ll.head.next.next.next = new Node(80);
		ll.printList(head);
		System.out.println("Reversing list");
		//ll.reverseList(head);
		ll.printList(ll.reverseList(head));		
		ll.deleteNode(60);
		System.out.println("deleting node with data 60");
		ll.printList(head);
	}
}
