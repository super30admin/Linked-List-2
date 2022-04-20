// Time complexity: O(n) where n is the number of nodes in the linked list.
// Space complexity: O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
 class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        // Find the middle node using slow and fast pointers.
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reversing the second half of the list.
        ListNode prev = null;
        ListNode curr = slow.next;
        fast = curr.next;
        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;   
        }
        curr.next = prev;   // For the last node.
        
        //Splitting the linked list into 2 parts.
        slow.next = null;
        
        // Merging the two parts.
        slow = head;
        fast = curr;
        ListNode temp = null;
        while(fast != null) {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
}