// Time Complexity : O(n + m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just needed to align both lists to same length.


// Your code here along with comments explaining your approach in three sentences only
// First I count the lengths of both linked lists to know which one is longer.
// Then I move the pointer of the longer list ahead by the length difference so both pointers are equally far from the end.
// After that I move both pointers together until they meet, which is the intersection node.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int counta = 0;
        int countb = 0;

        ListNode a = headA;
        ListNode b = headB;

        // count length of list A
        while (a != null) {
            a = a.next;
            counta++;
        }

        // count length of list B
        while (b != null) {
            b = b.next;
            countb++;
        }

        // reset pointers
        a = headA;
        b = headB;

        // move pointer of longer list
        if (counta > countb) {
            int diff = counta - countb;
            while (diff-- > 0) {
                a = a.next;
            }
        } else {
            int diff = countb - counta;
            while (diff-- > 0) {
                b = b.next;
            }
        }

        // move both pointers until they meet
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }
}
