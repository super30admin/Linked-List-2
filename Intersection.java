public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        // finding length

        ListNode head = headA;
        int countA = 0;

        while (head != null) {
            head = head.next;
            countA++;
        }

        head = headB;
        int countB = 0;
        while (head != null) {
            head = head.next;
            countB++;
        }

        int def = 0;
        if (countA > countB) {
            def = countA - countB;
            while (def > 0) {
                headA = headA.next;
                def--;
            }
        } else {
            def = countB - countA;
            while (def > 0) {
                headB = headB.next;
                def--;
            }
        }
        while (headA != null) {
            if (headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;

        }
        return null;
    }
}