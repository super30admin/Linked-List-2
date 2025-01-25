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

 /*
    Leetcode problem 160: Intersection of Two Linked lists
    T.C: O(m + n) :: S.C: O(1) - Amortized T.C from O(2*(m + n))

    Solved using two pointers: First, find the length of both the Linked Lists. Then move the head of the
    list with the longer length, such that the two list heads have the same number of nodes to be traversed
    until the end. Now, move both heads and check if they coincide at any of the nodes from the two lists.
    Return the head of any list (which could be the point of intersection or a null value i.e. disjoint lists).
*/

public class IntersectionofTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}