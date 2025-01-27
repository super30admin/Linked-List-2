// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Split list
//reverse second half
//merge list

// * Definition for singly-linked list.
  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public void reorderList(ListNode head) {
        while(head==null || head.next==null){
            return;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode slow = curr;
        ListNode fast = curr;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast = fast.next.next;
        }
        ListNode first = curr;
        ListNode second = slow;
        ListNode prev1 = null;
        ListNode next = null;
        prev.next = null;
        while(second!=null){
            next = second.next;
            second.next = prev1;
            prev1 = second;
            second = next;
        }
        second = prev1;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(first!=null && second!=null){
            current.next = first;
            first = first.next;
            current = current.next;
            current.next = second;
            second = second.next;
            current = current.next;
        }
        while(first!=null){
            current.next = first;
        }
        head = dummy.next;
    }
}