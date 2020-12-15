// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class ReorderListSolution {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
      val = x; 
    }
  }
  public void reorderList(ListNode head) {
    if (head == null) 
      return;
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    fast = reverseLinkList(slow.next);
    slow.next = null;
    slow = head;
    while (fast != null) {
      ListNode tmp = slow.next;
      slow.next = fast;
      fast = fast.next;
      slow.next.next = tmp;
      slow = tmp;
    }
  }
  private ListNode reverseLinkList(ListNode head) {
    if(head == null || head.next==null)
      return head;
    ListNode rev = reverseLinkList(head.next);
    head.next.next = head;
    head.next = null;
    return rev;
  }
}