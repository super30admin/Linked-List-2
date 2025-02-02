// Time Complexity : TC = O(N/2) +  O(N/2) + O(N) ~ O(N),
// Space Complexity : SC = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        // TC = O(N/2) +  O(N/2) + O(N) ~ O(N), SC = O(1)
        // null
        if(head == null || head.next == null) return;
        // 1. find middle of the list
        ListNode slow = head, fast = head;
        // for odd go to mid, for even go to mid - 1, so next & nex.next != null
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. reverse the 2nd half
        fast = reverse(slow.next);
        // breaking thle LL into 2
        slow.next = null;
        // 3. merge the 2 LLs
        slow = head;
        ListNode temp = null;
        while(fast != null) { // only check for fast, as in odd fast will 1st become null & in even both will become null together
            temp = slow.next; // taking only 1 extra pointer will work
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head) {
        // null
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head, fast = head.next;
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