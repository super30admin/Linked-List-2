// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach

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
		 
		 if(head == null || head.next == null) return; 
		 
		 ListNode slow = head;
		 ListNode fast = head;
		 
		 while(fast.next != null && fast.next.next != null) {
			  slow = slow.next;
			  fast = fast.next.next;
		 }
		 
		 fast = reverse(slow);
		 slow = head;
		 
		 ListNode temp = null;
		 
		 while(fast != null && slow != null) {
			  temp = slow.next;
			  slow.next = fast;
			  fast = fast.next;
			  slow.next.next = temp;
			  slow = temp;
		 }
		 
	}
	
	private ListNode reverse(ListNode head) {
		 ListNode prev = null;
		 ListNode curr = head;
		 ListNode next = null;
		 
		 while(curr != null) {
			  next = curr.next;
			  curr.next = prev;
			  prev = curr;
			  curr = next;
		 }
		 return prev;
	}
}