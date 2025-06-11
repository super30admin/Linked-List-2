/*
  Time complexity: O(n)
  Space complexity: O(1)

  Code ran successfully on Leetcode: Yes

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
        if(head==null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev = null;

        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second!=null)
        {
            ListNode temp = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp;

            first = temp;
            second = temp2;
            
        }

        if(first!=null)
            first.next = null;
    }
}
