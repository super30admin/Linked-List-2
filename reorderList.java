// Time complexity - O(n) - length of the linked list
// Space Complexity - O(1)
// Works on leetcode

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
        ListNode slow = head;
        ListNode fast = head;
        
        // find middle element
        while(fast!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode p1 = head;
        // Reverse the second half
        ListNode p2 = reverse_list(slow.next);
        ListNode nextp1; 
        ListNode nextp2;
        slow.next = null;
        
        // Break the connections and reconnect with the reversed list
        while(p1 != null && p2 != null){
            nextp1 = p1.next;
            nextp2 = p2.next;
            p1.next = p2;
            p2.next = nextp1;
            p1 = nextp1;
            p2 = nextp2;
        }  
        
    }
    
    // Function to reverse a list
    private ListNode reverse_list(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    } 
}
