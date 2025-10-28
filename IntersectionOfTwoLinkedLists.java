/**
 * Leet code : https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * <p>
 * Approach:
 * 1. Calculate the lengths (heights) of both linked lists.
 * 2. Advance the head of the longer list by the difference in lengths so both lists are aligned at the same distance from the end.
 * 3. Traverse both lists together, node by node, until a common node is found (reference equality), or until the end is reached.
 * 4. If an intersection exists, return the intersecting node; otherwise, return null.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int heightA = 0;
        int heightB = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != null) {
            currentA = currentA.next;
            heightA++;
        }

        while (currentB != null) {
            currentB = currentB.next;
            heightB++;
        }

        while (heightA > heightB) {
            headA = headA.next;
            heightA--;
        }

        while (heightB > heightA) {
            headB = headB.next;
            heightB--;
        }

        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
