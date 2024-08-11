// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
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
      ListNode fast = head;
      ListNode slow = head;
  
      while(fast.next!=null && fast.next.next!=null) {
        fast = fast.next.next;
        slow = slow.next;
      }
  
      ListNode prev = null;
      ListNode current = slow.next;
      while(current!=null) {
        ListNode temp = current.next;
        current.next = prev;
        prev = current;
        current = temp;
      }
      slow.next = null;
  
      ListNode first = head;
      ListNode second = prev;
      while(second!=null) {
        ListNode temp1 = first.next;
        ListNode temp2 = second.next;
        first.next = second;
        second.next = temp1;
        first = temp1;
        second = temp2;
      }
    }
  }