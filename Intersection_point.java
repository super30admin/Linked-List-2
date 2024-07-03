// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// use two different pointers to travel each list. 
// when pointer reach at the end assign it to head of other.
// if they are not intersecting then they will become null and return any one of them
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
        if(headA == null || headB == null){
            return null;
        }

        ListNode l1 = headA;
        ListNode l2 = headB;

        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;

            // if pointers meet, return any of the pointer 
            if(l1 == l2){
                return l1;
            }
            // If l2 reaches end, assign it with head of first
            if(l2 == null){
                l2 = headA;
            }
            // If l1 reaches at the end, assign it with head of second
            if(l1 == null){
                l1 = headB;
            }
        }

        return l2;
    }
}