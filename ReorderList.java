// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/* First find middle of list. Then we reverse the second half. Then we perform single pass on both the half and merge 2 lists */
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

        //Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the 2nd half i.e from slow.next to end
        ListNode curr = slow.next;
        ListNode prev = null;
        ListNode temp = null;
        slow.next = null;

        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //Merge the 2 lists
        ListNode first = head;
        ListNode second = prev;
        temp = null;

        while(second != null) {

            temp = first.next;
            first.next = second;
            second = second.next;
            
            first.next.next = temp;
            first = temp;
        }
        
    }

    //TC :- O(n)
    //SC :- O(1)
}