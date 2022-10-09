// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
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
class Solution {
    public void reorderList(ListNode head) {
        // base
        if (head == null || head.next  == null) return;

        //1. find middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //2. split the linked list into two and reverse from slow.next onwards
        fast = reverse(slow.next);
        slow.next = null;

        // 3. join the next two LLs
        slow = head;
        ListNode temp = slow.next;

        while (fast != null) {
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
            if (temp!=null) temp = temp.next;
        }


    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode nextCurr = head.next;

        while (nextCurr !=null) {
            curr.next = prev;
            prev= curr;
            curr = nextCurr;
            nextCurr = nextCurr.next;
        }

        curr.next = prev;

        return curr;
    }
}
