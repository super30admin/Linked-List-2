package linkedlistQ;

public class ReorderList {

	  public ListNode reverse(ListNode head){
	        ListNode prev=null;
	        ListNode curr=head;
	        ListNode fast=head.next;
	        while(fast!=null){
	            curr.next=prev;
	            prev=curr;
	            curr=fast;
	            fast=fast.next;
	        }
	        curr.next=prev;
	        return curr;
	    }
	    public void reorderList(ListNode head) {
	        if(head==null || head.next==null) return;
	        ListNode slow=head;
	         ListNode fast=head;
	        
	        // finding middle
	        while(fast.next!=null && fast.next.next!=null){
	            slow=slow.next;
	            fast=fast.next.next;
	        }
	        
	        //reverse
	        fast=reverse(slow.next);
	        //to end the ll slow.next=null;
	        slow.next=null;
	        //slow is at back bringing it to front.
	        slow=head;
	        
	        //merge 2 lists
	        while(fast!=null){
	            ListNode temp=slow.next;
	            slow.next=fast;
	            fast=fast.next;
	            slow.next.next=temp;
	            slow=temp;
	        }
	        
	    }
}
