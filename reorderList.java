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
    // T.C : O(n)
    // S.C : O(1)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // Find middle of linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half of linked list and break LL into 2 distinct LL
        fast = reverse(slow.next);
        // split into two
        slow.next = null;
        // Merging two lists
        slow = head;
        ListNode temp = slow.next;
        while (fast != null) {
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
            if (temp != null) {
                temp = temp.next;
            }
        }
    }
    
    // reverse linked list logic
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}