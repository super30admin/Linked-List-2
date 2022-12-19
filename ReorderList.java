// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class ReorderList {

  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public void reorderList(ListNode head) {
        // Divide the list in half 
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        } 

        fast = slow.next;
        slow.next = null;

        // Reverse the 2nd half
        ListNode prev = null;
        ListNode curr = fast;
        ListNode temp = null;
        
        while (curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //merge first halg and 2nd half
        ListNode first = head;
        ListNode second = prev;
        while (first != null && second != null){
            temp = first.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = temp;
        }
    }

    
}
