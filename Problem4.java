// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = 1;
        int lengthB = 1;

        ListNode cursorA = headA;
        ListNode cursorB = headB;

        while (cursorA != null) {
            cursorA = cursorA.next;
            lengthA++;
        }

        while (cursorB != null) {
            cursorB = cursorB.next;
            lengthB++;
        }

        if (lengthA > lengthB) {
            cursorA = move(headA, lengthA - lengthB);
            cursorB = headB;
        } else {
            cursorB = move(headB, lengthB - lengthA);
            cursorA = headA;
        }

        while (cursorA != null) {
            if (cursorA == cursorB) {
                return cursorA;
            } else {
                cursorA = cursorA.next;
                cursorB = cursorB.next;
            }

        }
        return null;
    }

    private ListNode move(ListNode head, int diff) {

        while (diff != 0) {
            head = head.next;
            diff--;
        }

        return head;

    }
}