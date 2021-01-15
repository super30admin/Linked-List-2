// Time Complexity : The time complexity is O(n) where n is the length of the longest list
// Space Complexity : The space complexity os O(1)
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

        // Two Pointers at each of the list heads
        ListNode cur1 = headA;
        ListNode cur2 = headB;

        if(headA == null || headB == null){
            return null;
        }

        while(cur1!=null || cur2!=null){

            // If first pointer reaches null, point it to the head of second list
            if(cur1 == null){
                cur1=headB;
            }

            // If second pointer reaches null, point it to the head of first list
            if(cur2 == null){
                cur2=headA;
            }

            if(cur1 == cur2){
                return cur1;
            }

            cur1=cur1.next;
            cur2=cur2.next;

        }

        return null;

    }
}