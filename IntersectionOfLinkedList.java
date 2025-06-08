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
// Time complexity - O(n)
// Space Complexity - O(1)
// Did you face any issues - No
// Solved on leetcode - yes
// Use two pointers to traverse both lists; when one pointer reaches the end, switch it to the head of the other list. This way, both pointers travel the same total distance, and if there's an intersection, they'll meet there. If there's no intersection, both will reach null at the same time and return null.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists; switch to the other head when end is reached
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // either intersection node or null
    }
}
