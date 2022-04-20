/**
Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
TC: O(n)
SC: O(1)
*/
// Approach 1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

// Approach 2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode ptrA = headA, ptrB = headB;
        
        while (ptrA != null) {
            ++lenA;
            ptrA = ptrA.next;
        }
        
        while (ptrB != null) {
            ++lenB;
            ptrB = ptrB.next;
        }
        
        ptrA = headA;
        while (lenA > lenB) {
            --lenA;
            ptrA = ptrA.next;
        }
        
        ptrB = headB;
        while (lenB > lenA) {
            --lenB;
            ptrB = ptrB.next;
        }
        
        while (ptrA != ptrB) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return ptrA;
    }
}