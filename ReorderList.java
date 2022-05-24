//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //find mid of the linkedlist
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow ptr will be at the midpoint
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        //merge
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}
