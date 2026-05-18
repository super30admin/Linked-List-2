// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        if(head.next == null || head.next.next == null)
        {
            return;
        }

        ListNode slow = head, fast = head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headB = slow.next;
        headB = Reverse(headB);
        slow.next = null;

        ListNode headA = head;

        while(headB != null)
        {
            ListNode tempA = headA;
            ListNode tempB = headB;
            headA = headA.next;
            headB = headB.next;
            tempA.next = tempB;
            tempB.next = headA;

        }

    }

    public ListNode Reverse(ListNode head) {
        if(head == null)
        {
            return head;
        }

        ListNode slow = null, medium = null, fast = head;

        while(fast != null)
        {
            slow = medium;
            medium = fast;
            fast = fast.next;
            medium.next = slow;
        }

        return medium;
    }
}