// Time Complexity : O(n) where n is number of nodes in LinkedList
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We find the mid point by using 2 pointers slo and fast. Then we reverse the 2nd part of list and get the new head.
   Now we iterate and merge the 2 lists in an alternate manner. After the 2 lists are merged he have the head of the new 
   merged linked list. 
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
    public void reorderList(ListNode head) {
        if(head == null)
            return;

        ListNode slo = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slo = slo.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slo);
        ListNode first = head;
        ListNode second = head2;

        while(second.next != null) {
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}