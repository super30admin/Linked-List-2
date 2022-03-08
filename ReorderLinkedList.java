//Tc:o(N)

public class Solution {
    public void reorderList(ListNode head) {
        //find the middle element
        
        ListNode slow = head;
        ListNode fast = head;
        while( fast.next != null  && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next); 
        slow.next = null;
        // merge
        ListNode temp = null; 
        while(fast != null)
        {  
           temp = head.next; 
           head.next = fast;
           fast = fast.next;
           head.next.next = temp; 
           head = temp; 
           
             
        }    
    }
    
    private ListNode reverse(ListNode head)
        {
                
                ListNode prev = null;
 
                ListNode curr = head;
                ListNode temp = null;

                while(curr != null)
                { 
                    temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                    
                } 
        return prev;
            
        }
}
