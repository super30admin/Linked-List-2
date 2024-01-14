// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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

 //TC: O(m+n)
 //SC : O(1)
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA  = 0;
        ListNode curr = headA;
        while(curr != null){
            lenA++;
            curr = curr.next;
        }
        int lenB  = 0;
        curr = headB;
        while(curr != null){
            lenB++;
            curr = curr.next;
        }

        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }

        while(lenA < lenB){
            headB = headB.next;
            lenB--;
        }

        while(headA != headB){
             headA = headA.next;
             headB = headB.next;
        }

        return headA;
    }
}