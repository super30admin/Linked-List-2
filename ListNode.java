/**
 * Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    // Did this code successfully run on Leetcode : Yes
    // Time Complexity : O(max(m,n)); m = headA.length, n = headB.length
    // Space Complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        int l1 = 0;
        int l2 = 0;

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        while(ptr1 != null) {
            l1 += 1;
            ptr1 = ptr1.next;
        }
        ptr1 = headA;

        while(ptr2 != null) {
            l2 += 1;
            ptr2 = ptr2.next;
        }
        ptr2 = headB;

        if(l1 > l2) {
            int diff = l1 - l2;
            while(diff > 0) {
                ptr1 = ptr1.next;
                diff -= 1;
            }
        }

        if(l2 > l1) {
            int diff = l2 - l1;
            while(diff > 0) {
                ptr2 = ptr2.next;
                diff -= 1;
            }
        }

        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}