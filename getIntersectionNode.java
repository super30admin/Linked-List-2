// Time Complexity : O(max(n, m)) where n and m are the lengths of the LLs
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Calculate lengths of both LLs and move the start ptr of the lower length LL by the difference in the 
// lengths steps.
// Now move ptrs concurrently from both LL start points (head of longer LL and head + diff of shorter LL)
// Their meeting point is the answer.


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

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA, p2 = headB;
        int n1 = 0, n2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            n1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            n2++;
        }
        p1 = headA;
        p2 = headB;
        int diff = Math.abs(n1 - n2);
        while (diff > 0) {
            if (n2 > n1) {
                if (p2 == null) return null;
                p2 = p2.next;
            }
            else {
                if (p1 == null) return null;
                p1 = p1.next;
            }
            diff--;
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}