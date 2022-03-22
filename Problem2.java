// Time Complexity : O(n) for traversing linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        
        // find mid
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse from mid
        ListNode mid = reverse(slow.next);
        slow.next = null;
        
        // merge both
        ListNode a = head; 
        ListNode b = mid;
        
        while (a != null && b != null) { // or just b != null
            ListNode temp1 = a.next;
            a.next = b;

            ListNode temp2 = b.next;
            b.next = temp1;

            a = temp1;
            b = temp2;        
        }       
    }
    
    // reverse function
    private ListNode reverse (ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
