//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
public class ReorderList {
	
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
	
	 public void reorderList(ListNode head) {
	        
	        if(head == null || head.next == null) return;
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        fast = reversed(slow.next);
	        slow.next = null;
	        slow = head;
	        
	        while(fast != null) {
	            ListNode temp = slow.next;
	            slow.next = fast;
	            fast = fast.next;
	            slow.next.next = temp;
	            slow = temp;
	        }
	        
	    }
	    
	    private ListNode reversed(ListNode head) {
	        ListNode prev = null;
	        ListNode curr = head;
	        ListNode pred = curr.next;
	        
	        while(pred != null) {
	            curr.next = prev;
	            prev = curr;
	            curr = pred;
	            pred = pred.next;
	        }
	        curr.next = prev;
	        
	        return curr;
	    }

}
