package sol;








public class ReorderList {
	public class ListNode {
	      int val;
	     ListNode next;
     ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	    }
	
    public ListNode reverseList(ListNode head) {
     if(head==null)   
     {return null;}
        if(head.next==null){return head;}
        
        ListNode n= reverseList(head.next);
        
        head.next.next=head;
        head.next=null;
        return n;
    
        
    }
    
    
    public void reorderList(ListNode head) {
   
        int size=0;
        ListNode ptr=head;
        
        while(ptr!=null){
            ptr=ptr.next;
            size++;
        }
       //  System.out.println(size);
        
        if(size%2==0){
            
            size=size/2;
        }else{
            
            size=(size/2)+1;
        }
       // System.out.println(size);
        
        ptr= head;
        int it=1;
        while(it!=size){
            ptr=ptr.next;
        it++;
        }
       
        
        ListNode second=ptr.next;
        ptr.next=null;
        
        second=reverseList(second);
        
       
        
        ListNode h1=head;
       //  System.out.println(h1.val+" "+second.val);
        
        while(second!=null&&h1!=null){
            
           ListNode temp1=h1.next;
            
            h1.next=second;
            second=h1.next.next;
            h1.next.next=temp1;
            h1=temp1;
        }
    
    
    }
}
