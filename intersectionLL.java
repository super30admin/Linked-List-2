// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		 int m = 0;
		 int n = 0;
		 
		 ListNode curr = headA;
		 while(curr != null) {
			  m++;
			  curr = curr.next;
		 }
		 
		 curr = headB;
		 while(curr != null) {
			  n++;
			  curr = curr.next;
		 }
		 
		 while(m > n) {
			  headA = headA.next;
			  m--;
		 }
		 
		 while(n > m) {
			  headB = headB.next;
			  n--;
		 }
		 
		 while(headA!=headB) {
			  headA = headA.next;
			  headB = headB.next;
		 }
		 
		 return headA;
	}
}