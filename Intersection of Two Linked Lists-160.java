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
 // Time Complexity: O(n+m)
 // Space Complexity:O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curr = headA;
        int lenA = 0;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        int lenB = 0;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;        
    }
}
