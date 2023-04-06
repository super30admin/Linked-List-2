/**
 * Definition for singly-linked list.
//Time Complexity : O(n)
//Space Complexity : O(1)
 
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
    
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        
        //creating 2 node fast and slow
        ListNode slow = head;           
        ListNode fast = head;
        
        //calculating mid
        //we need to stop the slow pointer just before the mid
        while(fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reverse the linklist
        fast = reverse(slow.next);    //head2 points to the reversed link list's head
        slow.next = null;           //assigning slow.next = null to avoid cycling
    
        slow = head;      //head1 points to the head of first link list
        
        //merge both the link list
        while(fast!= null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;   
        }
        
    }
    

    private ListNode reverse(ListNode current){
        
        //reversing the link list
        ListNode prev = null;
        ListNode fast = current.next;
        
        while(fast!= null){
            
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
            
        }
        current.next = prev;
        return current;
        
//         ListNode prev= null;
//         ListNode next;
        
//         while(current != null){
//             next = current.next;
//             current.next = prev;
//             prev= current;
//             current = next;
//         }
//         return prev;
     
    }
    
    
    
    
    
    
//     public void reorderList(ListNode head) {
        
        
//         //creating 2 node fast and slow
//         ListNode slow = head;           
//         ListNode fast = head;
        
//         //calculating mid
//         //we need to stop the slow pointer just before the mid
//         while(fast.next!= null && fast.next.next != null){
//             fast = fast.next.next;
//             slow = slow.next;
//         }
        
//         //reverse the linklist
//         ListNode head2 = reverse(slow.next);    //head2 points to the reversed link list's head
//         slow.next = null;           //assigning slow.next = null to avoid cycling
    
//         ListNode head1 = head;      //head1 points to the head of first link list
//         ListNode temp1;
//         ListNode temp2;
        
        
//         //merge both the link list
//         while(head2!= null){
//             temp1 = head1.next;
//             temp2 = head2.next;
//             head1.next = head2;
//             head2.next = temp1;
//             head1 = temp1;
//             head2 = temp2;     
//         }
        
//     }
    
    
    
//     private ListNode reverse(ListNode current){
        
//         //reversing the link list
//         ListNode prev= null;
//         ListNode next;
        
//         while(current != null){
//             next = current.next;
//             current.next = prev;
//             prev= current;
//             current = next;
//         }
//         return prev;
//     }
}
