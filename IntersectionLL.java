// Time - O(m+n) m= len of LL1 , n= len of LL2
// Space - O(1)
// Executed on Leetcode


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode A_ptr = headA;
        ListNode B_ptr = headB;
        while(A_ptr!=B_ptr) {
            if(A_ptr==null) A_ptr = headB;
            else A_ptr = A_ptr.next;
            if(B_ptr==null) B_ptr = headA;
            else B_ptr = B_ptr.next;
        }
        return A_ptr;
    }
}