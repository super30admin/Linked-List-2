// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// mentioned inline with code

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
        //edge case check
        if(headA == null || headB == null) return null;
        
        // finding length of both lists
        ListNode currA = headA, currB = headB;
        int lenA = 0, lenB = 0;
        while(currA != null) {
            lenA++;
            currA = currA.next;
        }
        while(currB != null) {
            lenB++;
            currB = currB.next;
        }
        //if list A has more nodes, adjusting headA
        while(lenA > lenB) {
            lenA--;
            headA = headA.next;
        }
        // adjusting headB in case list B has more nodes
        while(lenA < lenB) {
            lenB--;
            headB = headB.next;
        }
        
        // in case of valid intersection scenario, both headA and headB will be eqidistant from the intersecting point now.
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

