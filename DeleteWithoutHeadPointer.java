// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : GeeksForGeeks (Yes)
// Any problem you faced while coding this : No

public class DeleteWithoutHeadPointer {
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	class GfG {
		void deleteNode(Node node) {
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}
}
