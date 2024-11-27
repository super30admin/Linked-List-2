// Time Complexity : O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//approach: first we iterate and find out the lengths of each list.then we start iterating through the arrays
//such that the intersection is equidistant.then iterate on both lists till they meet.

// Your code here along with comments explaining your approach
public class intersection {
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
        ListNode curA=headA;
        ListNode curB=headB;
        int countA=0;
        int countB=0;
        while(curA!=null)
        {
            countA++;
            curA=curA.next;
        }
        while(curB!=null)
        {
            countB++;
            curB=curB.next;
        }
        curA=headA;
        curB=headB;
        while(countA>countB)
        {
            curA=curA.next;
            countA--;
        }
        while(countB>countA)
        {
            curB=curB.next;
            countB--;
        }
        while(curA!=curB)
        {
            curA=curA.next;
            curB=curB.next;
        }
        return curA;

    }
}
}
