// 143. Reorder List - https://leetcode.com/problems/reorder-list/
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) 
            return;
        //find mid
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse second half of list
        fast = reverseList(slow.next);
        //disconnect lists and set slow to list head
        slow.next = null;
        slow = head;
        //connect them both
        while(slow != null && fast != null) {
            ListNode curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
     private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;			
		ListNode prev = null, curr = head, fast = head.next;		
         //using 3 pointers, two to keep track of forming connections in reverse
		while(fast != null) {										
            // fast to keep track of remaining list to be reversed 
			curr.next = prev;										
			prev = curr;
			curr = fast;
			fast = fast.next;
		}
		curr.next = prev;
		return curr;											
    }
}