// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        if(head == null || head.next == null) return;
        //find mid
      ListNode slow = head;
      ListNode fast = head;
      while(fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      //slow is in middle so reverse the link list
      fast = reverseList(slow.next);
      slow.next = null; //remove the connection 
      slow = head;
      
      //merge list
      while(fast != null) {
        ListNode temp = slow.next;
        slow.next = fast;
        fast = fast.next;
        slow.next.next = temp;
        slow = temp;
      }
        
    }
    public ListNode reverseList(ListNode head) {
      if(head == null || head.next == null) return head;
      
      // three pointers to reverse the list
      ListNode prev = null;
      ListNode curr = head;
      ListNode fast = head.next;
      
      // move all pointers one step
      while(fast != null){
        curr.next = prev;
        prev = curr;
        curr = fast;
        fast = fast.next;
      }
      curr.next = prev;
      return curr;
    }
}