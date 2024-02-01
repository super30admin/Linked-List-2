// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Solution: have slow(normal pace) and fast pointer(double pace). will get slow just before mid point
// Reverse half of the linked list from slow.next to end. We will have spit the list now. reset slow to head.
// First half is intact. 2nd split list is reversed now.
// Make connections: Take 1 node from 1st, 2nd node from 2nd list and 3rd from 1st and so on.

public class Problem2 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }

        ListNode reversed = reverse(slow.next);
        slow.next = null;

        fast = reversed;
        slow = head;

        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast=fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}