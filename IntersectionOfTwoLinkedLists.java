// Time Complexity : O(n)
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
        
        if(headA == null || headB == null)  return null;
        
        ListNode A = headA;
        ListNode B = headB;
        
        int sizeA = 0, sizeB = 0;
        
        while(A != null){
            A = A.next;
            sizeA++;
        }
        
        while(B != null){
            B = B.next;
            sizeB++;
        }
        
        A = headA;
        B = headB;
        
        int diff = Math.abs(sizeA - sizeB);
        if(sizeB > sizeA){
            
            while(diff-- > 0){
                B = B.next;
            }
            
        }else if (sizeA > sizeB){
            
            while(diff-- > 0){
                A = A.next;
            }
            
        }
        
        while(A != null){
            if(A == B)  return A;
            A = A.next;
            B = B.next;
        }
        return null;
    }
}
