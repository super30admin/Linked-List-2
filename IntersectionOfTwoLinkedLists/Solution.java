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

// Time Complexity : O(2m + 2n) -> O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Calculate the length of both LinkedList. Bring the pointer of larger list in level with the smaller list. Now. traverse both list
 * simultaneously until an both nodes are same. if there is no intersection. Both pointer will point to null. If there is intersection
 * It will point to the intersection node.
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int m = 0, n = 0;
        int count = 0;
        ListNode tempA= headA;
        ListNode tempB = headB;

        while(tempA != null) { //O(m)
            tempA = tempA.next;
            m++;
        }

        while(tempB != null) { //O(n)
            tempB = tempB.next;
            n++;
        }

        //O(m-n)
        if(m < n) {
            while(count < n-m) {
                headB = headB.next;
                count++;
            }
        }
        else if(n < m) {
            while(count < m-n) {
                headA = headA.next;
                count++;
            }
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}