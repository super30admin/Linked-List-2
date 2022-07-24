/*
Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
TC: O(n)
SC: O(1)
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = head;
        int i = 0;
        
        while (end != null) {
            ++i;
            
            if (i % k == 0) {
                start = reverse(start, end.next);
                end = start;
            }
            end = end.next;
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode cur = start.next;
        ListNode next = cur.next;
        ListNode first = start.next;
        
        while (next != end) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        start.next = cur;
        first.next = end; // or end
        
        return first;
    }
}