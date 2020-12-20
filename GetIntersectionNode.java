// Time Complexity : O(M + N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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
        
        if(headA == null || headB == null) {
            return null;
        }
        
        int lenA = 0, lenB = 0;
        
        ListNode curr = headA;
        
        while(curr != null) {
            curr = curr.next;
            lenA++;
        }
        
        curr = headB;
        
        while(curr != null) {
            curr = curr.next;
            lenB++;
        }
        
        while(lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        
        while(lenB < lenA) {
            headA = headA.next;
            lenA--;
        }
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}