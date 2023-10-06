// Leetcode Problem : https://leetcode.com/problems/reorder-list/description/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I break down the solution into three parts. I split the linked list into two halfs. I reverse the
 * second half and I merge the two linked lists.
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
        if(head.next==null)
        {
            return;
        }
        //Splitting LL into half
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //head of second LL
        ListNode headB = slow.next;
        slow.next=null;
        //reversing LL
        headB = reverseLL(headB);
        //merging LL
        ListNode temp = head,headA=head;
        while(headB!=null)
        {
            if(temp==headA)
            {
                headA=headA.next;
                temp.next=headB;
            }
            else if(temp==headB)
            {
                headB=headB.next;
                temp.next=headA;
            }
            temp=temp.next;

        }


    }

    public ListNode reverseLL(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode slow = null,fast=null;
        while(head!=null)
        {
            slow=fast;
            fast=head;
            head=head.next;
            fast.next=slow;
        }
        fast.next=slow;
        return fast;
    }
}