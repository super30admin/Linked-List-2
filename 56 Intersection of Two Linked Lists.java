// Time Complexity :  0(m+n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        ListNode currB = headB;
        int countA = 0;
        int countB = 0;

        while(currA!=null)
        {
            currA = currA.next;
            countA++;
        }
        while(currB!=null)
        {
            currB = currB.next;
            countB++;
        }

        currA = headA;
        currB = headB;

        while(countB > countA)
        {
            currB = currB.next;
            countB--;
        }

        while(countA > countB)
        {
            currA = currA.next;
            countA--;
        }

        while(currA!=currB)
        {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}