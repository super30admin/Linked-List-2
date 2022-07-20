
//Time Complexity- O(n)
// Space complexity- O(1)
//Successfully ran on leetcode

class Solution {
 public void reorderList(ListNode head) {
     
     if(head==null || head.next== null) return; 
     
     //1. Find middle of LL
     
     ListNode slow= head;
     ListNode fast= head;
     
     while(fast.next!= null && fast.next.next != null){
         slow= slow.next;
         fast= fast.next.next;
         
     }
     
     
     //2. Reverse the 2nd part of LL
     
     fast= reverse(slow.next);
     slow.next = null;   // break down the list into 2 parts
      
     
     //3. Merge the two separated lists
     slow= head; 
     ListNode temp= null;
     while(fast!= null){
         temp = slow.next;
         slow.next= fast;
         fast= fast.next;
         slow.next.next= temp;
         slow= temp;
         
     }
     
 }
 
 private ListNode reverse(ListNode head){
     
     if(head== null || head.next== null) return head;
     ListNode prev= null;
     ListNode curr = head;
     ListNode fast= head.next;
     
     while(fast!= null){
         
         curr.next= prev;
         prev= curr;
         curr= fast;
         fast= fast.next;
     }
     curr.next= prev;
      return curr;
 }
}