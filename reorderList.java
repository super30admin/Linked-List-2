// Time Complexity : O(n), O(n/2) each for finding middle, reversing the list and merging them
// Space Complexity : O(1), everything is in place
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Find the middle by using two pointers, reverse the second half to get the newhead
// of the list and then merge them.

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
        if(head == null) return;

        ListNode slow = head;
        ListNode fast = head;


        // find the middle of the list
        //odd and even length case 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse 2nd half of list
        ListNode head2 = reverse(slow.next);
        slow.next = null; // required to split into two lists

        //merge two list.
        while(head2 != null){
            ListNode temp = head.next;
            head.next = head2;
            head2 = head2.next;
            head.next.next = temp;
            head = temp;
        }
    }

    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}