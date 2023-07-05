/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // Find the middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode p = slow;
        ListNode q = p.next;
        while (q != null) {
            ListNode temp = q.next;
            q.next = p;
            if (p == slow) {
                p.next = null;
            }
            p = q;
            q = temp;
        }

        // Merge the two lists
        ListNode tailNode = p;
        ListNode headNode = head;
        while (tailNode != null && headNode != null) {
            ListNode headTemp = headNode.next;
            headNode.next = tailNode;
            ListNode tailTemp = tailNode.next;
            tailNode.next = headTemp;
            headNode = headTemp;
            tailNode = tailTemp;
        }
    }
}