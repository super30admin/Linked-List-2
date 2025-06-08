//Time Complexity O(m+n)
//Space Complexity O(1)
//Runs on LeetCode YES
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
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = 0;
        int lengthB = 0;
        int diff = 0;
        ListNode a = headA;
        ListNode b = headB;

        while (a != null) {
            a = a.next;
            lengthA++;
        }
        while (b != null) {
            b = b.next;
            lengthB++;
        }

        if (lengthA >= lengthB) {
            diff = lengthA - lengthB;
            while (headA != null && diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            diff = lengthB - lengthA;
            while (headB != null && diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != headB && (headA != null && headB != null)) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}