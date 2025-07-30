// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : find mid point of linked list. Reverse second half. Merge both halves

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
    ListNode global;
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        //find mid of linked list
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        //reverse second half
        helper(head2);
        ListNode reverseHead = global;
        //merge both
        while(head!=null && global!=null){
            ListNode temp = global.next;
            global.next = head.next;
            head.next = global;
            head = global.next;
            global = temp;
        }
    }
    private ListNode helper(ListNode curr){
        if(curr==null||curr.next ==null){
            global = curr;
            return curr;
        }
        //ListNode tail = helper(curr.next);
        //tail.next = curr;
        helper(curr.next).next = curr;
        curr.next = null;
        return curr;
    } 
}