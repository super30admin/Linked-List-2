// Time complexity 0(n)
// space complexity 0(1)
// Code successfully executed in leetcode


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // edge case
        if(head == null || head.next == null) return;
        // For finding the middle element
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next !=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
// Slow will be at the middle and reversing the ll and merging the ll
        fast = reverseList(slow);
        slow = head;
        ListNode temp;
        while(slow!=null && fast!=null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        } 
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode Fast = head.next; 
         while(Fast!=null){
             current.next = prev;
             prev = current;
             current = Fast;
             Fast = current.next;
         }
        current.next = prev;
        return current;
    }
}