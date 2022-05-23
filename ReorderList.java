// Time Complexity :O(n) where n is no of nodes
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we'll cut our list into half, first part will always be equal or greater.then, well reverse second half
//then, by using three pointers to the nodes well merge the lists(we'll take temp ptr which will store slow's next)
//then, we'll make slow's next as fast.we'll inc fast, then make slow's next's next as temp.then will make slow as temp will
// do this until fast is not null because fast is smaller and it will become null first

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        fast = reverseList(fast);
        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode fast = head.next;
        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = curr.next;
        }
        curr.next = prev;
        return curr;
    }
}