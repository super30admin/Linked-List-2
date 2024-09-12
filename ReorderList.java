// Time Complexity : O(n) --> where n is length of the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (143): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        // edge
        if (head == null || head.next == null) return;
        
        // find middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode curr;
        
        // merger the initial list and reverse second part of the list
        while (fast != null) {
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode Nxt = head.next;
        
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = Nxt;
            if (Nxt != null) Nxt = Nxt.next;
        }
        return prev;
    } 
}