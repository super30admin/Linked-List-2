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

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes

class Reorder {
    public void reorderList(ListNode head) {

        if(head==null||head.next==null)
            return;

        ListNode slow = head;

        ListNode fast = head;

        ListNode current = null;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        fast = reverse(slow.next);

        slow.next = null;

        slow = head;

        while(fast!=null)
        {
            current = slow.next;

            slow.next = fast;

            fast= fast.next;

            slow.next.next = current;

            slow =current;
        }


    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;

        ListNode current = head;

        ListNode fast = current.next;

        while(fast!=null)
        {
            current.next=prev;
            prev=current;
            current=fast;
            fast=fast.next;
        }

        current.next=prev;

        return current;

    }


}