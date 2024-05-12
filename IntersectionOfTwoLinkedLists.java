// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Problem: 160
 * 
 * Initution: If we can have the same head start for both LinkedLists we can find the common node of intersection easily
 * 
 * so find the length of the both linkedlists
 * 
 * and make the longer length node move towards the intersection until both length matches.
 * 
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeofA = 0;
        int sizeOfB = 0;

        ListNode slow = headA;
        ListNode fast = headB;

        while (slow != null) {
            slow = slow.next;
            sizeofA++;
        }

        while (fast != null) {
            fast = fast.next;
            sizeOfB++;
        }

        slow = headA;
        fast = headB;

        while (sizeofA > sizeOfB) {
            slow = slow.next;
            sizeofA--; // Decrement the size
        }

        while (sizeOfB > sizeofA) {
            fast = fast.next;
            sizeOfB--;// Decrement the size
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}