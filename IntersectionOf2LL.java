// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
       ListNode curr = headA;
      int lenA = 0; int lenB = 0;
      
      //find length link list A and B
      while(curr != null) {
        lenA++;
        curr = curr.next;
      }
      curr = headB;
       while(curr != null) {
        lenB++;
        curr = curr.next;
      }
      //Move the pointer in longest link list to make the listlist length equal
      while(lenA > lenB) {
        headA = headA.next;
        lenA--;
      }
      while(lenB > lenA) {
        headB = headB.next;
        lenB--;
      }
      //check nodes are equal
      while(headA != headB) {
        headA = headA.next;
        headB = headB.next;
      }
        return headA;
    }
   
}