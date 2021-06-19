// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : geeksforgeeks
// Any problem you faced while coding this : no

/*
 * 1. Copy next node data to current node
 * 2. then remove next node means point next to next.next.
 */

public class DeleteWithoutHead {

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Function to delete a node without any reference to head pointer.
	class Solution {
		void deleteNode(Node del) {
			del.data = del.next.data;
			del.next = del.next.next;
		}
	}

}
