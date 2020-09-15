/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int sizeA = 0;
        int sizeB = 0;

        ListNode dummyA = headA;
        ListNode dummyB = headB;

        while (dummyA != null) {
            dummyA = dummyA.next;
            sizeA++;
        }
        while (dummyB != null) {
            dummyB = dummyB.next;
            sizeB++;
        }
        dummyA = headA;
        dummyB = headB;

        if (sizeA > sizeB) {
            while (sizeA != sizeB) {
                sizeA--;
                dummyA = dummyA.next;
            }
        } else {
            while (sizeA != sizeB) {
                sizeB--;
                dummyB = dummyB.next;
            }
        }

        while (dummyA != null && dummyB != null) {
            if (dummyA == dummyB)
                return dummyA;
            dummyA = dummyA.next;
            dummyB = dummyB.next;

        }
        return null;

    }

}