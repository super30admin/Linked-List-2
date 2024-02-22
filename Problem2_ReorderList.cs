// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public void ReorderList(ListNode head) {
        if(head == null) return;

        ListNode slow = head;
        ListNode fast = head.next;
        // Divide the list into 2 halves
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;

        //Reverse second half of the list
        ListNode prev = null;
        ListNode temp;
        while(fast != null) {
            temp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = temp;
        }
        fast = prev;

        //Merge the 2 lists
        while(fast != null) {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    return;
    }
}