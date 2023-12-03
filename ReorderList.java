// https://leetcode.com/problems/reorder-list/submissions/
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

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head != null && head.next != null){
            ListNode rev, slow = head, fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = reverse(slow.next);
            slow.next = null;
            slow = head;

            while(fast != null){
                ListNode temp = slow.next;
                slow.next = fast;
                fast = fast.next;
                slow.next.next = temp;
                slow = temp;
            }
        }
        
    }
    public ListNode reverse(ListNode slow){
        if(slow.next == null) return slow;
        ListNode prev = null, curr = slow;
        
        while(curr.next != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        return curr;
    }
}