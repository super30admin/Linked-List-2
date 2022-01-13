// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class ReorderList {

    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {

        //  Find the middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //  Reverse the second half
        ListNode prev = null;
        ListNode cur = slow.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        //  Detach the two lists
        slow.next = null;

        //  Merge the two lists
        ListNode t1 = head;
        ListNode t2 = prev;

        while (t1 != null && t2 != null) {
            ListNode next = t1.next;
            t1.next = t2;
            t2 = t2.next;
            t1.next.next = next;
            t1 = next;
        }
    }
}
