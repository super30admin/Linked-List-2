// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        //find the middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half
        fast = reverse(slow.next);
        //let's split the list into two portions
        slow.next = null;
        //merge two parts
        slow = head;
        ListNode temp = null;
        while(fast != null) {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode fast = head.next;
        while(fast != null) {
            cur.next = prev;
            prev = cur;
            cur = fast;
            fast = fast.next;
        }
        cur.next = prev;
        return cur;
    }
}