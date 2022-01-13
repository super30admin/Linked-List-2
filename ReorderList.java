package linkedList2;

public class ReorderList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	//Time Complexity : O(n), where n is the length of linked list
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public void reorderList(ListNode head) {
        // find mid
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse
        ListNode prev = null;
        ListNode curr = slow.next;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = null;
        
        // merge
        ListNode first = head;
        ListNode second = prev;
        
        while(second != null) {
            ListNode temp = first.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = temp;
        }
    }
}
