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

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        
        while(curA != null){
            lenA++;
            curA = curA.next;
        }
        
        ListNode curB = headB;
        while(curB != null){
            lenB++;
            curB = curB.next;
        }
        
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
        while(lenB > lenA){
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
