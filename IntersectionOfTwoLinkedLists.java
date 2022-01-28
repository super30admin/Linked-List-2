// Time Complexity : O(m+n)
// Space Complexity :O(1)
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
        //initialize lengths for LL A & B
        int lenA = 0;
        int lenB = 0;
        
        //intialize a pointer to help calculate length of both LL
        
        //calculate length of LL A
        ListNode curr = headA;
        
        while(curr !=null){
            curr = curr.next;
            lenA++;
        }
        
        //calculate length of LL B
        curr = headB;
        
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        
        //logic
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        //once lengths become same each pointers will move one by one to find intersection point
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}