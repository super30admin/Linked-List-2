// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain two pointers tempA which points to headA and tempB which points to headB. I traverse through the linked lists till tempA != tempB. After incrementing both pointers by 1, 
I check if either of them have become null. If both have become null, I return null(there exists no cycle). If one of them become null, I set it to the head of the other list. 
I come out of the loop if tempA == tempB which is where my cycle begins.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode tempA = headA, tempB = headB;

        while (tempA != tempB)
        {
            tempA = tempA.next;
            tempB = tempB.next;

            if (tempA == null && tempB == null)
            {
                return null;
            }

            if (tempA == null)
            {
                tempA = headB;
            }

            if (tempB == null)
            {
                tempB = headA;
            }

        }

        return tempA;
    }
}