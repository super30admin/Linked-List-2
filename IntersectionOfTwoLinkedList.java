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

 /* Time Complexity : O(n)
  *  n - lenghth of the linked list */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        //get the lengths of individual lists
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        //When length of list A is greater move to the node in A by the difference in the lengths of lists
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        //When length of list B is greater move to the node in B by the difference in the lengths of lists
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        //Keep traversing the lists till the nodes are equal to get the intersection node
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}