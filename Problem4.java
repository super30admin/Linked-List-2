// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We calculate the length of both the linked lists 
Based on the difference we move the pointer of either of one linked list and start traversing one node at a time until both the pointers meet
Return either of the pointer when the pointers meet
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
        ListNode currA = headA;
        ListNode currB = headB;
        int countA = 0;
        int countB = 0;
        //Get the length of two llinked ists
        while(currA != null) {
            countA++;
            currA = currA.next;
        }
        while(currB!= null) {
            countB++;
            currB = currB.next;
        }

        //Reset the pointer position to heads of node
        currA = headA; currB = headB;
        //Mark the position of pointer to the desired node based on count
        while(countB > countA) {
            currB = currB.next;
            countB--;
        }
        while(countA > countB) {
            currA = currA.next;
            countA--;
        }

        //return the node where the pointers meet
        while(currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}
