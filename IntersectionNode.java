/**
## Problem 4:  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
 
Time Complexity :   O (M+N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (160. Intersection of Two Linked Lists)
Any problem you faced while coding this :       No
 */

// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB == null){
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        while( a != b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }
}