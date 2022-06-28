// Time Complexity : O(m+n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, Ran on GFG
// Any problem you faced while coding this : No

//160. Intersection of Two Linked Lists
//https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = 0; // Length of list A
        int n = 0; // Lengrh of list B
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            tempA = tempA.next;
            m++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            n++;
        }

        if (m > n) {
            int diff = m - n;
            while (diff != 0) {
                headA = headA.next;
                diff--;
            }
        } else if (n > m) {
            int diff = n - m;
            while (diff != 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != headB) {
            if (headA == headB)
                break;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }
}
