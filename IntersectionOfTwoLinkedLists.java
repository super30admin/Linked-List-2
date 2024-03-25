// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        int a = 0;
        int b = 0;

        ListNode curr = headA;
        
        while (curr != null) {
            a++;
            curr = curr.next;
        }

        curr = headB;

        while (curr != null) {
            b++;
            curr = curr.next;
        }

        while(a > b) {
            headA = headA.next;
            a--;
        }

        while(b > a) {
            headB = headB.next;
            b--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headB;
    }
}