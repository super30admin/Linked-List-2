// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA =0; int lenB =0;
        lenA = length(headA);
        lenB = length(headB);
        ListNode res = null;
        while(lenB < lenA)
        {
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA)
        {
            headB = headB.next;
            lenB--;
        }
        while(headA != null && headB != null)
        {
            if(headA == headB) 
            {
                res = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return res;
    }
    private int length(ListNode root)
    {
        int count = 0;
        while(root != null)
        {
            root = root.next;
            count++;
        }
        return count;
    }
}