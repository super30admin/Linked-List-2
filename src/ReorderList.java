// Time Complexity:  O(n)
// Space Complexity: O(1)

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
        
        // end case
        if(head == null || head.next == null || head.next.next == null)
            return;

        // find mid node from the list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is at the mid node
        // reverse second half of the list
        fast = reverse(slow.next);
        slow.next = null;

        // merge both lists
        slow = head;
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        ListNode extra = cur.next;;
        while(extra != null) {
            cur.next = prev;
            prev = cur;
            cur = extra;
            extra = extra.next;
        }
        cur.next = prev;
        return cur;
    }
}
