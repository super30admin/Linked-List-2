
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//  	Not able to do intuition on this solution

// Your code here along with comments explaining your approach

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
           if (headA == null || headB == null)
        	return null;

        ListNode currA = headA, currB = headB;
        boolean isFirstRoundA = true, isFirstRoundB = true;

        while (currA != currB) {
        	currA = currA.next;
        	currB = currB.next;

        	if (currA == null && isFirstRoundA) {
        		currA = headB;
        		isFirstRoundA = false;
        	}

        	if (currB == null && isFirstRoundB) {
        		currB = headA;
        		isFirstRoundB = false;
        	}
        }

        return currA;
    }
}