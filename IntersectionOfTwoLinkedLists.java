// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * In this Problem, we use two pointers approach to adjust the difference the gap in length of lists initially
 * we make sure that both headA and headB are at the same disatnce from the intersection if any.
 * Then we move both the pointers one by one and return when they are the same
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        while(ptrA != null && ptrB != null) {
            if(ptrA == ptrB) return ptrA;
            
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        
        if(ptrA == null) {
            // ptrB is not null
            while(ptrB != null) {
                ptrB = ptrB.next;
                headB = headB.next;
            }
        }else if(ptrB == null) {
            // ptrA is not null
            while(ptrA != null) {
                ptrA = ptrA.next;
                headA = headA.next;
            }
        }
        
        while(headA != null && headB != null) {
            
            if(headA == headB) {
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}