// Time Complexity :O(n)
// Space Complexity ;O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
  public void reorderList(ListNode head) {
    if (head == null)
      return;

    // Find the middle node
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Reverse the nodes from the middle node
    ListNode prev = null;
    ListNode curr = slow;
    ListNode tmp;
    while (curr != null) {
      tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
    }

    // Merge the two list with each other using two pointers
    ListNode first = head;
    ListNode second = prev;
    while (second.next != null) {
      tmp = first.next;
      first.next = second;
      first = tmp;

      tmp = second.next;
      second.next = first;
      second = tmp;
    }
  }
}