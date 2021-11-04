// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class ReorderList {
	 public void reorderList(ListNode head) {
	        
	        int len=0;
	       ListNode curr=head;
	        while(curr!=null){
	            len+=1;
	            curr=curr.next;
	        }
	      if(len==1 || len==2){return ;}
	        int mid=len/2+1;
	        int count=1;
	        ListNode two=null;
	        curr=head;
	        while(curr.next!=null){
	            if(count==mid){
	                two=curr;
	                two.next=reverse(two.next);
	                break;
	            }
	            count++;
	            curr=curr.next;
	        }
	        
	        ListNode one=head;
	         ListNode middle=two.next;
	        two.next=null;
	        while(one!=null && middle!=null){
	            ListNode temp1=one.next;
	            ListNode temp2=middle.next;
	            one.next=middle;
	            middle.next=temp1;
	            one=temp1;
	            middle=temp2;
	        }
	             
	    }
	    ListNode reverse(ListNode head){
	        ListNode prev=null;
	        ListNode curr=head;
	        ListNode next=null;
	        while(curr!=null){
	            next=curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=next;
	        }
	        return prev;
	    }
	    
	    public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	     }
}
