public class Problem4 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Time Complexity :  O(m+n)
    // Space Complexity : O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int countA = 0;
        int countB = 0;
        ListNode curr = headA;
        while (curr != null) {
            curr = curr.next;
            countA++;
        }
        curr = headB;
        while (curr != null) {
            curr = curr.next;
            countB++;
        }
        while (countA > countB) {
            headA = headA.next;
            countA--;
        }
        while (countB > countA) {
            headB = headB.next;
            countB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
