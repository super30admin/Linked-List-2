// Time Complexity = O(n+m)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Calculate the length of each LL, and then start from a point of same length, and check till both lists are not the same
// if they are same return either of the nodes as the intersecting node.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA=0, lenB=0;
        // Calculate the lengths of each LL
        ListNode cur = headA;
        while (cur != null) {
            cur = cur.next;
            lenA++;
        }

        cur = headB;
        while (cur != null) {
            cur = cur.next;
            lenB++;
        }

        // bring both the lists to the same length
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Compare both the strings now
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}