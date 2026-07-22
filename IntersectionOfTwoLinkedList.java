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
public class Solution {
    /*
        TC - O(n + m) (n and m are the lengths of the two lists)
        SC - O(1)

        Solution is to find the intersection node of two singly linked lists by first aligning their starting positions.
        Traverse both linked lists to calculate their lengths (len1 and len2).
        Identify the longer list and move its pointer forward by the difference in lengths.
        After alignment, both pointers have the same number of nodes remaining until the end.
        Traverse both lists simultaneously:
        If the pointers become equal, that node is the intersection.
        If both pointers reach null, the lists do not intersect, so return null.
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode curr = headA;

        while (curr != null) {
            curr = curr.next;
            len1++;
        }

        curr = headB;

        while (curr != null) {
            curr = curr.next;
            len2++;
        }

        while (len1 < len2) {
            headB = headB.next;
            len2--;
        }

        while (len2 < len1) {
            headA = headA.next;
            len1--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}