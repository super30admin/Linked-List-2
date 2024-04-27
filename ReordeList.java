/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//Time Complexity : O(N), N is the length of linke dlist
//Space Complexity : O(1)
//Did this code run successfully on Leetcode : 
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        //Find the middle
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the second half
        fast = reverseLinkedList(slow.next);
        slow.next = null;
        slow = head;


        //Make the connection
        while(slow != null && fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

        private ListNode reverseLinkedList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

}