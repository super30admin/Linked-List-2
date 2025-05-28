/*
 * TC - O(m + n)
 * SC - O(1)
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class P4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = 0;
        int lB = 0;
        ListNode curr = headA;
        while (curr != null) {
            curr = curr.next;
            lA ++;
        }
        curr = headB;
        while (curr != null) {
            curr = curr.next;
            lB ++;
        }
        while (lA > lB) {
        headA = headA.next;
        lA --;
        }
        while (lB > lA) {
            headB = headB.next;
            lB --;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}