// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        if(head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow.next;
        ListNode curr = prev.next;
        ListNode temp = curr;

        while(curr!= null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

curr = prev;
        slow.next = null;
        slow = head;

        while(slow!=null){
            ListNode temp1 = slow.next;
            slow.next = curr;
            ListNode temp2 = curr.next;
            curr.next = temp1;
            slow = temp1;
            curr = temp2;
        }


    }
}