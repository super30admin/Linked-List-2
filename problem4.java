//Problem4 - https://leetcode.com/problems/intersection-of-two-linked-lists

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode slowA = headA;
        ListNode slowB = headB;
        int lengthA = 0;
        int lengthB = 0;

        while (slowA != null) {
            lengthA++;
            slowA = slowA.next;
        }

        while (slowB != null) {
            lengthB++;
            slowB = slowB.next;
        }

        slowA = headA;
        slowB = headB;
        while (lengthA > lengthB) {
            slowA = slowA.next;
            lengthA--;
        }

        while (lengthB > lengthA) {
            slowB = slowB.next;
            lengthB--;
        }

        while (slowA != null && slowB != null) {
            if (slowA == slowB)
                return slowA;
            slowA = slowA.next;
            slowB = slowB.next;
        }
        return null;
    }
}
