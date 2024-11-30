
public class FindIntersection {
	
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        
	        int size1 = getLength(headA);
	        int size2 = getLength(headB);
	        
	        ListNode shortList = size1 < size2? headA : headB;
	        ListNode longList = size1 > size2? headA : headB;
	        
	        if(size1 == size2){
	            shortList = headA;
	            longList = headB;
	        }
	        
	        for(int i=0; i<Math.abs(size1-size2); i++){
	            longList = longList.next;    
	        }
	        
	        while(shortList != null){
	            if(shortList == longList){
	                return shortList;
	            }
	            
	            shortList = shortList.next;
	            longList = longList.next;
	        }
	        
	        return null;
	    }
	    
	    public int getLength(ListNode head){
	        int size = 0;
	        while(head != null){
	            size++;
	            head = head.next;
	        }
	        
	        return size;
	    }

}
