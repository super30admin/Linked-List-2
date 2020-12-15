//TC: O(N)
// SC: O(1)

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
        
        if(head == null){
            return;
        }
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        fast = reverse(slow.next);
        
        slow.next = null;
        slow = head;
        
        while(fast != null){
            ListNode temp = slow.next;
            
            slow.next = fast;
            fast  = fast.next;
            slow.next.next = temp;
            slow = temp;
            
        }
        
    }
    
    private ListNode reverse(ListNode head){
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return reversed;
    }
    
    
    
}