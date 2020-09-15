// Time Complexity : O(n)
// Space Complexity : O(1)
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
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode l1 = head;
        ListNode result = new ListNode(0);
        ListNode l2 = reverse(slow);
        
        while(l2 != null && l2 != l1){
            result.next = l1;
            l1 = l1.next;
            result = result.next;
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }
        result = result.next;
        
    }
    private ListNode reverse(ListNode slow){
        ListNode prev = null, curr = slow, next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
