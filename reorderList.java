// Time complexity - O(n)
// Space complexity - O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
        
              if(head == null || head.next == null){
            return ;
        }
        
        ListNode slowptr = head;
        ListNode fastptr = head;
        //reach the middle of the linked list
        while(fastptr.next != null && fastptr.next.next != null  ){
            
            fastptr = fastptr.next;
            fastptr = fastptr.next;
            slowptr = slowptr.next;
            
        }
        if(fastptr.next != null){
            
            fastptr = fastptr.next;
        }
        //reverse the linked list after the slowptr
        
             ListNode prev = slowptr;
             ListNode current = slowptr.next;
             ListNode next = slowptr.next;
            // ListNode start = slowptr.next;
     //   System.out.println(slowptr.next.val);
        
        while(next != null && next.next != null){
            
            
            next = next.next;
            current.next = prev;
            prev = current;
            current = next;
            
        }
        current.next = prev;
        ListNode start = slowptr.next;
        slowptr.next = null;
        start.next = null;
   //   while(head != null){
            
        //   System.out.println("valye of heads is"+head.val);
      //      head = head.next;
      // }
       // while(fastptr != null){
            
      //      System.out.println("value of start is" +fastptr.val);
    //        fastptr = fastptr.next;
  //      }
        //merging the 2 lists
        
        ListNode first = head;
        ListNode second = first.next;
        ListNode third = fastptr;
        ListNode fourth = fastptr.next;
        
 //         System.out.println(first.val);
  //      System.out.println(second.val);
  //      System.out.println(third.val);
  //      System.out.println(fourth.val);
        
        while(fourth != null){
            
            first.next = third;
            first = second;
            third.next = second;
            third = fourth;
            second = second.next;
            fourth = fourth.next;
        }
        
        first.next = third;
        
        if(second != null){
            
            third.next = second;
        }
        
    }
}