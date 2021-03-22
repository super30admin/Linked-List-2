// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


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
        ListNode pA = headA;
        ListNode pB = headB;
        int lenA = 0;
        int lenB = 0;
        int startA = 0;
        int startB = 0;
        while(pA != null){
            pA = pA.next;
            lenA++;
        }
        while(pB != null){
            pB = pB.next;
            lenB++;
        }
        
        if(lenB > lenA){
            startB = lenB-lenA;
        }
        else if(lenA > lenB){
            startA = lenA - lenB;
        }
        pA = headA;
        pB = headB;
        if(lenA > lenB){
            while(startA > 0){
                pA=pA.next;
                startA--;
            }
        }
        if(lenB > lenA){
            while(startB > 0){
                pB=pB.next;
                startB--;
            }
        }
        
        
        while(pA != null || pB != null){
            if(pA == pB){
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
            
        }
        
        return null;
    }
}