// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        ListNode slow= head,fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow);
        ListNode node = head;
        while(node != null){
            ListNode temp = node.next;
            ListNode temp2 = rev.next;
            node.next = rev;
            rev.next = temp;
            node = temp;
            rev = temp2;
        }
        return;
    }
    
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode n = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return n;
    }
}
