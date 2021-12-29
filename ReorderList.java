// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

lass Solution {
    public void reorderList(ListNode head) {
       
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
     
        ListNode curr = head2;
        ListNode prev = null;
        ListNode newnext =null;
        if(head2 != null && head2.next != null){
           newnext = head2.next; 
        }
       
        
        while(curr != null){
          curr.next = prev;
          prev = curr;
          curr = newnext;
            if(newnext != null){
                newnext = newnext.next;
            }
          
        }
        
        head2 = prev;
        
        while(head2 != null){
           ListNode temp = head.next;
            head.next = head2;
            head2 = head2.next;  
            head.next.next = temp;
            head = temp;
        }
    }
}