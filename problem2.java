// Time Complexity: O(n)
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
        // find the middle point of the list
        ListNode slow = head, fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the nodes from slow to end of list

        
        ListNode prev = null;
        ListNode curr = slow;

        while (curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // use two pointers from start and slow (mid), and rearrange nodes
        curr = head;
        while (prev.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            curr = temp;

            temp = prev.next;
            prev.next = curr;
            prev = temp;
        }
        return;
    }
}
