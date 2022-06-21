/* Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

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
        //null
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        //find mid of LL
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is at the middle
        fast = reverse(slow.next);
        slow.next = null;
        //merge the lists
        slow = head;
        while(fast != null){
           ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}