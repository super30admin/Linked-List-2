// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : getting error :Error - Found cycle in the ListNode


// Your code here along with comments explaining your approach

1. find middle
2. reverse the second half 
3. merge both the list (fist half and second half 


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
        // null case
        if(head == null)
            return ;
        
       // find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode middle = slow;
        
        // reverse second list (second half after middle point)
        
       ListNode secondList = reverseList(middle);
        
        
        
        // merge two sorted lists
        ListNode first = head;
      //  ListNode secondList = prev;
        while(secondList != null)
        {
            ListNode temp =  first.next;
            first.next = secondList;
            first = temp;
            
            temp = secondList.next;
            secondList.next = first;
            secondList = temp;
            //head = first;
          
            
        }
        
        
    }
    
    private ListNode reverseList(ListNode start)
    {
        if(start == null || start.next == null)
            return start;
         ListNode ele =  reverseList(start.next);
        start.next.next = start;
        start.next = null;
        
        return ele;
    }
}