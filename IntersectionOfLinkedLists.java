// Time Complexity : O (n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes

// First get length of each list
// Start from the head and move the pointer of the longer list till the lengths are equal
// Now move both pointers, they meet at intersection point
public class IntersectionOfLinkedLists {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ptrA, ptrB;
        int nA = 0, nB = 0;

        // find the lengths of lists A and B
        for (ptrA = headA; ptrA != null; ptrA = ptrA.next) nA++;
        for (ptrB = headB; ptrB != null; ptrB = ptrB.next) nB++;

        // start from heads again
        ptrA = headA;
        ptrB = headB;

        // whichever is greater, move that ptr until they are equal
        while (nA > nB) {
            ptrA = ptrA.next;
            nA--;
        }
        while (nB > nA) {
            ptrB = ptrB.next;
            nB--;
        }

        // now they should meet at intersection point or end up at null
        // if they don't intersect
        while (true) {
            if (ptrA == null || ptrB == null) return null;
            if (ptrA == ptrB) return ptrB;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
    }
}
