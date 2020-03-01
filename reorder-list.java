// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        
        ListNode mid = findMid(head);
        ListNode rev = reverse(mid.next);
        mid.next=null;
        ListNode A=head, B=rev, nextA, nextB;
        
        while(B != null)
        {
            nextA=A.next;
            nextB=B.next;
            
            A.next=B;
            B.next=nextA;
            
            A=nextA;
            B=nextB;
        }
    }
    private ListNode findMid(ListNode node)
    {
        ListNode slow=node, fast=node;
        while(fast.next != null && fast.next.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node)
    {
        ListNode rev=null, cur=node, next;
        while(cur != null)
        {
            next=cur.next;
            cur.next=rev;
            rev=cur;
            cur=next;
        }
        return rev;
    }
}