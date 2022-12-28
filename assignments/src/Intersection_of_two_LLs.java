public class Intersection_of_two_LLs {

    // Time: O(n+m), Space: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode ptrA = headA, ptrB = headB;

        while (ptrA != null) {
            lenA++;
            ptrA = ptrA.next;
        }
        while (ptrB != null) {
            lenB++;
            ptrB = ptrB.next;
        }
        int diff = Math.abs(lenA-lenB);
        if (lenA > lenB) {
            for (int i = 0; i<diff; i++) {
                headA = headA.next;
            }
        }
        else {
            for (int i = 0; i<diff; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;

        }
        return null;
    }
}

class ListNode
{
    int data ;
    ListNode next;
    ListNode(int d)
    {
        data = d;
        next = null;
    }
}