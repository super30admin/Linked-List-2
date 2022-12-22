// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode curr = headA;
        while(curr != null)
        {
            curr = curr.next;
            lenA++;
        }
        int lenB = 0;
        curr = headB;
        while(curr != null)
        {
            curr = curr.next;
            lenB++;
        }
        while(lenA > lenB)
        {
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA)
        {
            headB = headB.next;
            lenB--;
        }
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
