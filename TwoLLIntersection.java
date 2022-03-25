// Time Complexity : O(m+n) // m and n are lengths of the lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

        ListNode current = headA;

        int lenA=0, lenB=0;

        //find length of list A
        while(current != null)
        {
            current = current.next;
            lenA++;
        }

        current = headB;

        //find length of list B
        while(current != null)
        {
            current = current.next;
            lenB++;
        }

        //if list A is longer, keep moving headA till lenA = lenB
        while(lenA > lenB)
        {
            headA = headA.next;
            lenA--;
        }

        //if list B is longer, keep moving headB till lenA = lenB
        while(lenA < lenB)
        {
            headB = headB.next;
            lenB--;
        }

        //now move both heads together at 1x, wherever they meet is the intersection point
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }

        //return any of the heads
        return headA;

    }
}
