// Time Complexity : O(m+n) -> m len of linked list 1 and n is the len of linked list 2
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

        // finding len of List1
        int l1 = lengthOfList(headA);
        // finding len of List2
        int l2 = lengthOfList(headB);

        //if List1 is greater, then move head till the lengths are equal
        while(l1 > l2) {
            headA = headA.next;
            l1--;
        }

        //if List2 is greater, then move head till the lengths are equal
        while(l2 > l1) {
            headB = headB.next;
            l2--;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int lengthOfList(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            count++;
        }

        return count;
    }
}