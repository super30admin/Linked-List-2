// Time Complexity : O(m + n), where m and n are the lengths of the two linked lists.
// Space Complexity : O(1) — no extra space used, just two pointers.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
public class Intersectionof2Nodes_LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            // Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;

    }
}