/**
 * Find length of 2 lists. Check which is longer. Move longer list by gap between the lengths.
 * Then move both pointers by 1 and check where they are meeting.
 * TC: O(n)
 * SC: O(1)
 */

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return headA;
        }
        // length of A
        int lenA = length(headA);
        int lenB = length(headB);

        int gap = Math.abs(lenA - lenB);

        while (gap > 0) {
            if (lenA > lenB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
            gap--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }
}
