// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class DeleteNodeLLSolution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}
	public void deleteNode(ListNode node) {
		ListNode temp = node.next;
		node.val = temp.val;
		node.next = temp.next; 
	}
}