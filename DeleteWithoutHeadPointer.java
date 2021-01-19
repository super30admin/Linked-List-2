//Time Complexity : O(1)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
public class DeleteWithoutHeadPointer {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public void deleteNode(ListNode curr) {
		curr.val = curr.next.val;
		curr.next = curr.next.next;
	}

}
