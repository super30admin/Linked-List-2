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

    private ListNode flip(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null) return;

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null  && fast.next.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next != null){
            prev = slow;
            slow = slow.next;
        }

        ListNode flipped = flip(slow);

        ListNode node = head;

        while(node != prev && flipped != null){
            ListNode cache = node.next;
            node.next = flipped;
            flipped = flipped.next;
            node.next.next = cache;
            node = cache;
        }

        if(node == prev){
            node.next = flipped;
        }

        return;
        
    }
}
