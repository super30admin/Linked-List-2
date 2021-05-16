// Time complexity - O(n)
// Space complexity - O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
        
        
        
        int countA = 0;
        int countB = 0;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        
        while(dummyA.next != null){
            
            dummyA = dummyA.next;
            countA++;
        }
        while(dummyB.next != null){
            
            dummyB = dummyB.next;
            countB++;
        }
        
        if(countA > countB){
            
            while(countA != countB){
                
                headA = headA.next;
                countA--;
            }
        }
         else if(countA < countB){
            
            while(countA != countB){
                
                headB = headB.next;
                countB--;
            }
        }
        
        while(headA != headB && headA.next != null && headB.next != null){
            
            headA = headA.next;
            headB = headB.next;
        }
        
        if(headA == headB){
            
            return headA;
        }
        
        return null;
    }
}