// Time Complexity : O(N) - finding middle node is O(N), the other steps is O(N/2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : on Geeks for Geeks yes
// Any problem you faced while coding this :

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
        
        
        // first middle of linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse second part of list
        ListNode prev = null, curr = slow;
        ListNode tmp;
        while (curr != null){
            tmp = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        // merge two sorted linked lists
        ListNode first = head, second = prev;
        while (second.next != null){
            tmp = first.next;
            first.next = second;
            first = tmp;
            
            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}