
public class ReOrderLists {
	
	 public void reorderList(ListNode head) {
	        
	        if(head == null || head.next == null){
	            return;
	        }
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        while(fast.next != null && fast.next.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        //Reverse list
	        fast = reverseList(slow.next);
	        
	        
	        
	        
	        slow.next = null;
	        
	        slow = head;
	        
	        ListNode temp;
	        
	        while(slow != null && fast != null){
	            temp = slow.next;
	            slow.next = fast;
	            fast = fast.next;
	            slow.next.next = temp; 
	            slow = temp;
	        }
	        
	        
	    }
	    
	    private ListNode reverseList(ListNode head){
	        
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
