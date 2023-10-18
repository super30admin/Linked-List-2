public class IntersectionOfTwoLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        if (headA == headB)
            return headA;
        ListNode current = headA;
        while (current.next != null) {
            lenA++;
            current = current.next;
        }
        current = headB;
        while (current.next != null) {
            lenB++;
            current = current.next;
        }

        while (lenA > lenB) {

            headA = headA.next;
            lenA--;

        }
        while (lenB > lenA) {

            headB = headB.next;
            lenB--;

        }

        while (headA != headB) {

            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
