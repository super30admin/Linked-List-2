// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        
        //p1 points to A and p2 points to B
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        //while they point to diff nodes we increment them
        // if either of the pointers are null -> 
            // we reset them to the head of the other list
            // this ensures that we eventually encounter the intersection
        while(p1 != p2) {
            if(p1 == null) {
                p1 = headB; //reset to B
            } else {
                p1 = p1.next;
            }
            
            if(p2 == null) {
                p2 = headA; //reset to A
            } else {
                p2 = p2.next;
            }
        }
        
        return p1;
    }
}