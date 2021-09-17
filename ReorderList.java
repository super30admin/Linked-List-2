// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void reorderList(ListNode head) {
        //check for empty linked list or if it has a single element
        if(head == null || head.next == null) return;
        // initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        // find the middle
        // keep moving slow by 1x speed and fast by 2x speed
        // slow pointer will be at middle
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse
        // call the reverse method on node next to middle
        fast = reverse(slow.next);
        // move slow to head
        slow.next = null;
        slow = head;
        // merge the two lists
        ListNode temp = null;
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    // function to reverse a linked list
    private ListNode reverse(ListNode head){
        ListNode first = null;
        ListNode current = head;
        ListNode last = head.next;
        while(last != null){
            current.next = first;
            first = current;
            current = last;
            last = last.next;
        }
        current.next = first;
        return current;
    }
}