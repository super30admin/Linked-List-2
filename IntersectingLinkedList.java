// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }

        while (b != null) {
            b = b.next;
            headB = headB.next;
        }
        while (a != null) {
            a = a.next;
            headA = headA.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}