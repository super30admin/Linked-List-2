// Time Complexity : O(N) 
// Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


public class ReOrderList {
	  public void reorderList(ListNode head) {
	        if (head == null || head.next == null)
	          return;
	      
	      // step 1. cut the list to two halves
	      // prev will be the tail of 1st half
	      // slow will be the head of 2nd half
	      ListNode prev = null, slow = head, fast = head, l1 = head;
	      
	      while (fast != null && fast.next != null) {
	        prev = slow;
	        slow = slow.next;
	        fast = fast.next.next;
	      }
	      
	      prev.next = null;
	      
	      // step 2. reverse the 2nd half
	      ListNode l2 = reverse(slow);
	      
	      // step 3. merge the two halves
	      merge(l1, l2);
	    }
	    
	    ListNode reverse(ListNode head) {
	      ListNode prev = null, curr = head, next = null;
	      
	      while (curr != null) {
	        next = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = next;
	      }
	      
	      return prev;
	    }
	    
	    void merge(ListNode l1, ListNode l2) {
	      while (l1 != null) {
	        ListNode n1 = l1.next, n2 = l2.next;
	        l1.next = l2;
	        
	        if (n1 == null)
	          break;
	            
	        l2.next = n1;
	        l1 = n1;
	        l2 = n2;
	      }
	    }
}
