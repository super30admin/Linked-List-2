// Leetcode Problem : https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I set t1 at headA and t2 at headB. While t1!=null and t2!=-null, I set t1 = t1.next and t2 = t2.next. Now while
 * t1!=null, I increment both t1 and headA. Similarly while t2!=null, I increment both t2 and headB. At the end, 
 * while headA!=null && headB!=null, If headA==headB, I return headA. Else I traverse through the list. At the end
 * I return null i.e both lists don't intersect.
 */
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
        ListNode t1 = headA, t2 = headB;
        while(t1!=null && t2!=null)
        {
            t1=t1.next;
            t2=t2.next;
        }
        while(t1!=null)
        {
            t1=t1.next;
            headA=headA.next;
        }
        while(t2!=null)
        {
            t2=t2.next;
            headB=headB.next;
        }
        while(headA!=null && headB!=null)
        {
            if(headA==headB)
            {
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}