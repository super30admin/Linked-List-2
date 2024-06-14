/*
    LC - 143. Reorder List
    TC - O(n)
    SC - O(1)
    Approach - 
        1) Find the middle of LL
        2) Reverse the second half of LL
        3) Merge the two halves of the LL
*/

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        // 1. Find the middle of LL
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. Reverse the second half of LL
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        // Merge the two halves of the LL
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;
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