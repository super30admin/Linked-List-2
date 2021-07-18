// Time Complexity : O(n)
// Space Complexity : O(1)
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
        if(head == null)
            return;
        
        ListNode slow = head, fast = head;
        //find the mid point
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the second half od the list
        fast = reverseList(slow.next);
        
        //disconnect lists and set the slow to head
        slow.next = null;
        slow = head;
        
        //reorder the list
        while(slow != null && fast != null){
            ListNode curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null, slow = head, fast = head.next;
        //reverse
        while(fast != null){
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        
        slow.next = prev;
        return slow;
    }
}