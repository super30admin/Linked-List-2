// Time Complexity : O(lenA+lenB)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        int lenA = 0, lenB = 0;
        ListNode curr = headA;

        //Calculates the length of A
        while(curr != null){
            curr = curr.next;
            lenA++;
        }

        curr = headB;

        //Calculates the length of B
        while(curr != null){
            curr = curr.next;
            lenB++;
        }

        //Continues till both headA and headB have the same length
        while(lenA > lenB){
            headA = headA.next; //Moves headA one step
            lenA--;
        }

        //Continues till both headA and headB have the same length
        while(lenB > lenA){
            headB = headB.next; //Moves headB one step
            lenB--;
        }

        //Continues till both headA and headB are the same location as that is the intersection
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}