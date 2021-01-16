// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


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
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        
        // find middle
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse middle+1 to end
        ListNode reverseHead = reverse(slow.next);
        slow.next = null;
        
        slow = head;
        fast = reverseHead;
        ListNode temp;
        // merge
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            slow = temp;
            
            temp = fast.next;
            fast.next = slow;
            fast = temp;
        }
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}