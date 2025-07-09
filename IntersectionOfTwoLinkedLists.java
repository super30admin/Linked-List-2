// Time Complexity: O(m + n) Each pointer traverses at most m + n steps
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - Use two pointers starting at headA and headB.
// - When one pointer reaches the end, redirect it to the head of the other list.
// - If the two lists intersect, the pointers will meet at the intersection node after at most m + n steps.
// - If they do not intersect, both will reach null at the same time and return null.

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
        HashSet<ListNode> set = new HashSet<>();

        ListNode currA = headA;
        ListNode currB = headB;

        //loop till we find intersection
        while(currA != currB){

            //Move both pointers forward
            //If one list reaches null; start again from head of the other list
            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;

        }

        //Return intersection / null
        return currA;
    }
}