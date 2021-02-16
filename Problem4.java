// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
find diff in size, move pointers & check nodes for commonality
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

        int sizeA = 0;
        int sizeB = 0;
        ListNode A = headA;
        ListNode B = headB;

        while(A!=null){
            sizeA++;
            A = A.next;
        }

        while(B!=null){
            sizeB++;
            B = B.next;
        }

        int diff = Math.abs(sizeA-sizeB);

        ListNode currHigh = sizeA>sizeB ? headA : headB;
        ListNode currLow = sizeA>sizeB ? headB : headA;

        int i=0;
        while(i<diff){
            currHigh = currHigh.next;
            i++;
        }

        while(currLow!=null && currHigh!=currLow){
            currHigh = currHigh.next;
            currLow = currLow.next;
        }

        return currLow;
    }
}