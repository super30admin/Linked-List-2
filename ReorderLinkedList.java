// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : 2O(n) since we are iterating through the entire list twice
//Space Complexity: O(1) since we are not taking any extra space
class Solution {
    public void reorderList(ListNode head) {
        
        //[1, 2, 3, 4, 5]
        // Find mid 
        // From mid reverse the linkedList
        // now keep two pointers one at the begining and one pointer at mid+1
        // Keep adding the nodes one at each pointer
        if(head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        ListNode curr;
        while(fast != null){
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
            
        }
               
    }
    
    public ListNode reverseList(ListNode head) {
                
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
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