// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) 
            return;
        
        
        //find the midpoint
        ListNode slow = head, fast = head;
        
        //slow jumps 1 step at time and fast jumps 2 steps
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        //reverse second list
        fast = reverseList(slow.next);
        
        
        //disconnect list
        slow.next = null;
        
        //slow is the head of the first list
        slow = head;
        
        
        //make connections
        while(slow != null && fast != null) {
            
            ListNode curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    
     private ListNode reverseList(ListNode head) {
         
        if(head == null || head.next == null) 
            return head;			
         
		ListNode prev = null, curr = head, fast = head.next;	
         
        
		while(fast != null) {										
			curr.next = prev;										
			prev = curr;
			curr = fast;
			fast = fast.next;
		}
         
		curr.next = prev;
         
		return curr;											
    }
}






