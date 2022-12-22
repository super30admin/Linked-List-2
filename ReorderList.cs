// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public void ReorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = reverse(slow.next);
        slow.next = null;
        slow = head;
        while(reversed != null)
        {
            ListNode temp = slow.next;
            slow.next = reversed;
            reversed = reversed.next;            
            slow.next.next = temp;
            slow = temp;
        }
        //return head;
    }
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null)
        {            
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;

        }
        curr.next = prev;
        return curr;
    }
}
