public class IntersectionTwoLL {
    public ListNode intersectionTwoLL(ListNode headA, ListNode headB) {

        int lengthA = 0;
        int lengthB = 0;
        ListNode curr = headA;

        while (curr != null) {
            curr = curr.next;
            lengthA++;
        }
        curr = headB;
        while (curr != null) {
            curr = curr.next;
            lengthB++;
        }
        while (lengthA > lengthB) {
            lengthA--;
            headA = headA.next;
        }
        while (lengthB > lengthA) {
            lengthB--;
            headB = headB.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}