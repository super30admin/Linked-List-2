package Linked-List-2;

public class problem2 {
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
       
       //1. Find middle of LL
       ListNode slow = head;
       ListNode fast = head;
       
       while(fast.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       
       //2. Break in two and  reverse 2nd LL
       fast = reverse(slow.next);
       slow.next = null;
       
       //3. Reordering and merging the 2 lists
       slow = head;
       ListNode temp = slow.next;
       
       while( fast != null){
           slow.next = fast;
           fast = fast.next;
           slow.next.next = temp;
           slow = temp;
           if(temp != null){
               temp = temp.next;
           }
       }
       
   }
   
   private ListNode reverse(ListNode head){
       if(head == null || head.next == null) return head;
       
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
