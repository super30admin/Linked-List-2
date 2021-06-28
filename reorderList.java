package LinkedList2;

public class reorderList {
	
	 //Definition for singly-linked list.
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	    public void reorderList(ListNode head) {
	        if(head == null || head.next == null) return;
	        // find middle element
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        while(fast.next!=null && fast.next.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        fast = reverse(slow.next);

	        slow.next = null;
	        slow = head;
	        
	        //merge two lists
	        ListNode curr;        
	        while(fast!=null){
	            curr = slow.next;
	            slow.next = fast;
	            fast = fast.next;
	            slow.next.next = curr;
	            slow = curr;
	        }
	    }
	        private ListNode reverse(ListNode head){
	            ListNode prev = null;
	            ListNode curr = head;
	            ListNode fast = head.next;
	            
	            while(fast!=null){
	                curr.next = prev;
	                prev = curr;
	                curr = fast;
	                fast = fast.next;
	            }
	            curr.next = prev;
	            return curr;
	    }
	}
