/**
## Problem2 (https://leetcode.com/problems/reorder-list/)
 
Time Complexity :   O (N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (143. Reorder List)
Any problem you faced while coding this :       No
 */

// Input: head = [1,2,3,4]
// Output: [1,4,2,3]


// Definition for singly-linked list.
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {        
        ListNode slow = head;
        ListNode fast = head;
        
        // Finding mid
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the list from mid to end
        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        fast = prev;
        slow.next = null;  
        slow = head;
        
        //  Merge lists
        ListNode tmp;
        while (fast != null) {
              tmp = slow.next;
              slow.next = fast;
              fast = fast.next;
              slow.next.next = tmp;
              slow = tmp;
        }
    }
}