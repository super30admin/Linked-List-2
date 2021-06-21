// Time Complexity: O(n)
// Space Complexity: O(1)
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
        if(head == null || head.next == null) return;
        
        ListNode sPtr = head;
        ListNode fPtr = head;
        while(fPtr != null && fPtr.next != null){
            sPtr = sPtr.next;
            fPtr = fPtr.next.next;
        }
        
        fPtr = reverse(sPtr.next);
        sPtr.next = null;
        sPtr = head; 
        
        while(fPtr != null){
            ListNode temp = sPtr.next;
            sPtr.next = fPtr;
            fPtr = fPtr.next;
            sPtr.next.next = temp;
            sPtr = temp;
        }
    }
    
    public ListNode reverse(ListNode head){
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