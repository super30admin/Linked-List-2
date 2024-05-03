// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/**
 1. Find the mid point of the linked list
 2. reverse the second half of the list
 3. merge the 2 lists
  */
  class Solution {
    public void reorderList(ListNode head) {
        //find mid
        ListNode slow  = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse second half
        fast = reverse(slow.next);
        slow.next = null;

        //merge
        slow = head;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode fast = null;
        while(curr != null){
        fast = curr.next;
        curr.next = prev;
        prev = curr;
        curr = fast;
        }
        return prev;
    }
    
}