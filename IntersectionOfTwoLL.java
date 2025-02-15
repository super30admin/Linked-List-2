
// Time Complexity : O(n + m)  take the longest one
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lA = 0;
        int lB = 0;

        ListNode curr = headA;

        while (curr != null) {
            curr = curr.next;
            lA++;
        }

        curr = headB;
        while (curr != null) {
            curr = curr.next;
            lB++;
        }

        while (lA > lB) {
            headA = headA.next;
            lA--;
        }

        while (lB > lA) {
            headB = headB.next;
            lB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}