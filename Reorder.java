// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        while(fast != null){
            ListNode curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head, fast = head.next;
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