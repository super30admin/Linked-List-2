// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA 
// Any problem you faced while coding this : No, but this code wont work if the node to be deleted is the 
// tail node


// Your code here along with comments explaining your approach
// Copy value of next node into the node to be deleted and point the next of the node to be deleted to its 
// next.next

import java.util.*;

class Node {
	Node next;
	int val;
	Node(int v) {
		val = v;
		next = null;
	}
}

class deleteWithoutHead {
	
	static Node head;

	static Node deleteNode(Node node) {
		if (node == null) return head;
		node.val = node.next.val;
		node.next = node.next.next;
		return head;
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		linkedList list = new linkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.printList(deleteNode(list.head.next.next));
	}
}