//TC is O(n)
//SC is O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // find length of list A

        int lengthA = 1;
        while (pointerA.next != null) {
            pointerA = pointerA.next;
            lengthA++;
        }

        int lengthB = 1;
        while (pointerB.next != null) {
            pointerB = pointerB.next;
            lengthB++;
        }

        int diff = Math.abs(lengthA - lengthB);
        pointerA = headA;
        pointerB = headB;

        if (lengthA >= lengthB) {
            // moveA

            while (diff > 0) {
                diff--;
                pointerA = pointerA.next;
            }

        } else {
            while (diff > 0) {
                diff--;
                pointerB = pointerB.next;
            }

        }

        // both pointers should meet now
        if (pointerA == pointerB) {
            return pointerA;
        }

        while (pointerA != null && pointerB != null && pointerA != pointerB) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;

            if (pointerA != null && pointerB != null && pointerA == pointerB) {
                return pointerA;
            }
        }

        return null;
    }

}