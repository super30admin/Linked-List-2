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
//TC: O(N)
//SC: O(1)
class ReorderList {
    public void reorderList(ListNode head) {
        //null
        if(head == null || head.next == null || head.next.next == null) return;
        //finding the middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse second half
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        //merge two halves
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
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