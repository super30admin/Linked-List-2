// Time Complexity : O(n)
// Space Complexity : O(1)

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
        
        
        // Step 1 : Find the mid of the linked list
        // Step 2 : Reverse the second half of the linked list
        // Step 3 : Merge the first and second as per the expected order.
        ListNode head2 = null;
        
        // Step-1 : Find the mid using slow and fast pointers
        ListNode slow =  head;
        ListNode fast = head;
        
        // the mid resides at slow when fast reaches the end
        while (fast.next != null &&  fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Start at mid + 1
        head2 = slow.next;
        
        // remove the link between the first half and the second half
        slow.next =  null;
        
        // Step-2 : Reverse the second half of the linked list
        head2 = reverse(head2);
        
        // Step-3 : Merge the two linked lists
        
        while (head2 != null){
            
            // Store the first list from 2nd node as we might loose it if we connect to sec list.
            ListNode temp = head.next;
            
            // Connect first list with the second list
            head.next =  head2;
            
            // update the head2 for next iteration
            head2 =  head2.next;
            
            // Connect second to first list
            head.next.next = temp;
            
            // update the head1 for next iteration
            head = temp; 
        }
        
          
    }
    
    private ListNode reverse(ListNode head){
        
        if (head == null ) {
            return null;
        }
        
        // three pointer approach
        ListNode prev =  null;
        ListNode curr = head;
        ListNode next = head.next;
        
        while (curr != null){
            
            curr.next = prev;
            prev = curr;
            curr = next;
            
            if(next != null){
                next = next.next;
            }
            
        }
        
        return prev;
    }
}