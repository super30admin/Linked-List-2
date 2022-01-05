package sol;






public class IntersectionList {
	
	public class ListNode {
	      int val;
	     ListNode next;
   ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	    }
	
	  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		  
	        ListNode a=headA;
	        ListNode b=headB;
	        int size1=0;
	        
	        while(a!=null){
	            a=a.next;
	            size1++;
	        }
	        int size2=0;
	        while(b!=null){
	            b=b.next;
	            size2++;
	        }
	        
	      //  int diff= Math.abs(size2-size1);
	           a=headA;
	        b=headB;
	        while(size1>size2){
	            
	            a=a.next;
	            size1--;
	        }
	        
	        while(size2>size1){
	            b=b.next;
	            size2--;
	        }
	     
	        
	        while(a!=b){
	            a=a.next;
	            b=b.next;
	        }
	        return a;
	    }
}
