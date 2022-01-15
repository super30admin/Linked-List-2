// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        int lenA = 0;
        int lenB = 0;
        
        ListNode curr = headA;

        // find length of first linked list
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        
        // find length of second linked list
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        
        // keep moving the pointer in the longer linked list
        // so that remaining elements to traverse in both the linked lists are equal

        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        
        // keep traversing until same node is found on both the linked lists
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}