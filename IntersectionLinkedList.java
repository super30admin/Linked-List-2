// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode first = headA;
        ListNode second = headB;
        
        while(first != null && second != null) {
            first = first.next;
            second = second.next;
        }
        
        // If first reaches the end, move first to headA and proceed
        if (first == null) {
            first = headB;
        }
        
        // If second reaches the end, move second to headB and proceed
        if (second == null) {
            second = headA;
        }
        
        while (first != null && second != null) {
            first = first.next;
            second = second.next;
        }
        
        if (first == null) {
            first = headB;
        }
        
        if (second == null) {
            second = headA;
        }
        
        // Move both the pointers while they meet
        while (first != null && second != null) {
            if (first == second) return first;
            
            first = first.next;
            second = second.next;
        }
        
        
        return null;
    }
}