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
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }
        fast = reverseList(slow.next); // reverse and sepearte the LL
        slow.next = null;
        // merge
        slow = head;
        while(fast!=null){
            ListNode temp = slow.next;
            // ListNode temp2 = fast.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}