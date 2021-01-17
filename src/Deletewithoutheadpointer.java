/*
 * The complexity of the algorithm is O(1) .
 * 
 */
public class Deletewithoutheadpointer {

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// This function should delete node from linked list. The function
	// may assume that node exists in linked list and is not last node
	// node: reference to the node which is to be deleted
	class GfG {
		void deleteNode(Node node) {
			// Your code here

			node.data = node.next.data;
			node.next = node.next.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deletewithoutheadpointer objIn = new Deletewithoutheadpointer();

	}

}
