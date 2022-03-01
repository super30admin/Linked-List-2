/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 
 
 head = [1,2,5,4,3]
         1,2,5,4,3   
        1->5->
         f   s    
         1,2,5,4,3
         1->5, 2->4, 3     
 [1,5,2,3,4,5]
      1   2   
 
 [1,4,2,3]
 
 Clarifying questions 
 - singly linkedlist
 - O(1)
 - 
 
 [1,2,3,4,5]
  1 2 5 4 3
 1 5 2 4 
  1 5 2 4 3
  

 1 5 2 4 3
 
 
 [1,2,5    4,3]
         newsecond
   2
   
   [1,2,5,4,3]
    1 5 2 4
    
    1 2-> 3<-4 <-5
    
    1 2
    5 4 3
 
 
 1<-2<-5
 
 TC - O(m) + O(m/2) + 2*O(m/2) = O(m)
 SC - O(1)
 
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        if (head == null)
        {
            return;
        }
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        // find a mid of the 
        while (fastPtr != null && fastPtr.next != null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        ListNode second = reverseList(slowPtr);
        ListNode first = head;
        
        while (second.next != null)
        {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;
            
            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
    
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode current = head;
        
        
        while (current != null)
        {
            ListNode newNode = current.next;
            current.next = prev;
            prev = current;
            current = newNode;
        }
        
        return prev;
    }
}