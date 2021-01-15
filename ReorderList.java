// Time Complexity : The time complexity is O(n) where n is the number of list nodes
// Space Complexity : The space complexity is O(1)
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

        if(head == null || head.next==null){
            return;
        }

        ListNode slow=head;
        ListNode prev=null;
        ListNode fast=head;

        // Move the fast pointer the end of the list
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        // Reverse the second half of the list
        while(slow!=null){
            ListNode next = slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }

        slow=head;
        fast=prev;

        // Two pointers, 1 at the start and 1 at the end
        while(slow != fast){
            ListNode slowNext = slow.next;
            slow.next=fast;
            slow=slowNext;

            if(slow == fast){
                break;
            }

            ListNode fastNext = fast.next;
            fast.next=slow;
            fast=fastNext;
        }

        slow.next = null;

    }
}