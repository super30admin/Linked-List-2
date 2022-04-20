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

    // Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I 1st found the midpoint of my linked list by moving fast by
    //2x and slow by x. Then I forwarded next list from slow to my function reverse to reverse the list. In my main method, I
    //broke the tie to the 2nd half by pointing slow to null. Then I pointed my slow back to my head of 1st half and then took
    //temporary variable and then took 1 item from 1st half and then next from 2nd half and so on.

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode temp = null;
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = null;
        ListNode current = head;
        ListNode fast = head.next;
        while(fast != null){
            current.next = temp;
            temp = current;
            current = fast;
            fast = fast.next;
        }
        current.next = temp;
        return current;
    }
}