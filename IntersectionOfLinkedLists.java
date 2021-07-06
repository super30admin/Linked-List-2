public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        while (headA != null) {
            ListNode pointerB = headB;
            while(pointerB != null) {
                if (headA == pointerB) {
                    return headA;
                }
                pointerB = pointerB.next;
            }
            headA = headA.next;
        }

        return null;

    }
}