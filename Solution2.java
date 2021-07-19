
// Time complexity: O(N), where N is the number of nodes in the linked list.
// Space complexity: O(1)

class Solution2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
     

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        //find the mid of the linkedlist
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next; 
        }
        
        ListNode newHead = slow.next;
        slow.next = null; 
        
        ListNode first = head;
        // reverse the second list
        ListNode second = reverseList(newHead); 
        
        // reorder the list
        while(first!=null && second!=null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            
            first.next = second;
            second.next = firstNext; 
            
            first = firstNext;
            second = secondNext;
        }
    
    }
}