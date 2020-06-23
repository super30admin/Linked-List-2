// Time Complexity : O(n) n is number of nodes 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        
        if(head==null) return;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) 
        {
          slow = slow.next;
          fast = fast.next.next;
        }
        
        ListNode curr = slow;
        ListNode nextTemp = curr.next;
        ListNode prev = null;
        while(curr!=null)
        {
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
         ListNode first = head, second = prev;
        while (second.next != null) 
        {
          nextTemp = first.next;
          first.next = second;
          first = nextTemp;

          nextTemp = second.next;
          second.next = first;
          second = nextTemp;
        }
        
    }
    

    
}