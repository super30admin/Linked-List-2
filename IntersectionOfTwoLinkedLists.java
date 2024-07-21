//Time - O(n), Space - O(1)
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = 0, lenB = 0;
        ListNode p1 = headA, p2 = headB;

        while(p1 != null) {
            p1 = p1.next;
            lenA++;
        }

        while(p2 != null) {
            p2 = p2.next;
            lenB++;
        }

        p1 = headA;
        while(lenA > lenB) {
            p1 = p1.next;
            lenA--;
        }

        p2 = headB;
        while(lenB > lenA) {
            p2 = p2.next;
            lenB--;
        }

        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
