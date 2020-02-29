// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class ReorderList {
	
	ListNode head;

	static class ListNode {

		ListNode next;
		int val;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	
	private ListNode reorderList(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
		}
		
	
        
        ListNode secondHalf = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode curr = slow.next;
        while(secondHalf != null) {
        	slow.next = secondHalf;
        	secondHalf = secondHalf.next;
        	slow.next.next = curr;
        	slow = curr;
        	curr = curr.next;
        }
		
		
		
		
		return head;
    }

	
	private static ListNode reverse(ListNode secondHalf) {
		
		ListNode prev = null;
		ListNode curr = secondHalf;
		ListNode fast = curr.next;
		
		while(fast!=null) {
			curr.next = prev;
			prev = curr;
			curr = fast;
			fast = fast.next;
		}
		
		
		
		curr = prev.next;
		return curr;
	}
	
	
	private void printLinkedList(ListNode head) {

		ListNode l = head;

		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
	
	
	public static void main(String[] args) {
		ReorderList d = new ReorderList();
		d.head = new ListNode(1);
		d.head.next = new ListNode(2);
		d.head.next.next = new ListNode(3);
		d.head.next.next.next = new ListNode(4);
		d.head.next.next.next.next = new ListNode(5);
		d.head.next.next.next.next.next = new ListNode(6);
		d.head.next.next.next.next.next.next = new ListNode(7);
		d.head.next.next.next.next.next.next.next = new ListNode(8);
		
		d.reorderList(d.head);
		d.printLinkedList(d.head);


	}

}
