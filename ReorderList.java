

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
        if(head == null || head.next == null){
            // Empty or  Single node list, no reodering needed
            return;
        }

        // find the middle node using slow and fast pointer technique
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list 
        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = null;

        // Merge the first half and second half
        ListNode p1 = head;
        ListNode p2 = prev;
        while(p2 != null){
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }

        // p1.next = null;



    }
}
