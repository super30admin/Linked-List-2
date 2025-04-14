class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// TC: O(n) as the code is traversing all the nodes.
// SC: O(1) as apart from ListNode there is no extra space used. ListNode is
// expected to return from the method.

// Below approach is to traversing both the listNodes from the same lengths.
// Hence, start point is equalized prior.
public class IntersectionofTwoLinkedList {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        System.out.println(getIntersectionNode(headA, headB).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = 0;
        ListNode dummy = headA;
        while (dummy.next != null) {
            lA++;
            dummy = dummy.next;
        }

        int lB = 0;
        dummy = headB;
        while (dummy.next != null) {
            lB++;
            dummy = dummy.next;
        }
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (lA > lB) {
            lA--;
            currentA = currentA.next;
        }
        while (lA < lB) {
            currentB = currentB.next;
            lB--;
        }
        while (currentA != null) {
            if (currentA == currentB)
                return currentA;
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }

}