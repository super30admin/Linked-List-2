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
    
// Time Complexity : O(length of longest linked list)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
        /*
1. Adjust head of one of the list such that length is equal to both lists.
2. Now find the node with same reference to both lists. 
*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        int lenA = 0;
        int lenB = 0;
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null){
            lenA++;
            tempA = tempA.next;
        }
        while(tempB != null){
            lenB++;
            tempB = tempB.next;
        }   
        
        tempA = headA; tempB = headB;
        
        if(lenA>lenB){
            while((lenA-lenB)>0){
                tempA = tempA.next;
                lenB++;
            }
        }
        else if(lenA<lenB){
              while((lenB-lenA)>0){
                tempB = tempB.next;
                lenA++;
            }
        }
       
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        if(tempA != null)
           return tempA;    
        else
            return null;
    }
}