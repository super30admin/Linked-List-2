// https://leetcode.com/problems/intersection-of-two-linked-lists/

// Time Complexity: O(m + n)
// Space Complexity: O(1)

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        int lenA = 0;

        while(head1 != null) {
            head1 = head1.next;
            lenA++;
        }

        ListNode head2 = headB;
        int lenB = 0;

        while(head2 != null) {
            head2 = head2.next;
            lenB++;
        }

        if(lenA > lenB) {
            int diff = lenA - lenB;

            while(diff != 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = lenB - lenA;

            while(diff != 0) {
                headB = headB.next;
                diff--;
            }
        }

        for(int i = 0; i < Math.min(lenA, lenB); i++) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }
}