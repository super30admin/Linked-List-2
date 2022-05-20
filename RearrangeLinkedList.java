
// O(n) time || O(1) space


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
      
        
        // find the center
        ListNode slow= head, fast= head;
        
        
        while(fast!=null && fast.next !=null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        ListNode prev = null , curr = slow ,next;
        
        while(curr!=null){
            next =curr.next;
          
            curr.next =prev;
            prev=curr;
            curr= next;
            
        }
      
        ListNode first =head ,second =prev;
        while(second.next!=null){
              
              next = first.next;
              first.next = second;
              first =next;
            
            
             next  = second.next;
            second.next =first;
            second=next;
            
            
        }
       
        
       
        
    }
    
    
   
}
