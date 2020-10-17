/*
Author: Akhilesh Borgaonkar
Problem: LC 160. Intersection of Two Linked Lists (Linked List-2)
Approach: Using two-pointers approach. Initially, place both the pointers at equal length from the end of both Linked Lists.
    Then, traverse the list one at a time and check if both are equal. If the nodes are found equal then it is the point of intersection.
Time Complexity: O(m+n) where m and n are sizes of given Linked Lists.
Space complexity: O(1) constant.
LC verified.
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null)
            return null;
        
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        int lenA = 0;   
        while(ptrA.next != null){       //find length of List A
            ptrA = ptrA.next;
            lenA++;
        }
        
        int lenB = 0;                   //find length of List B
        while(ptrB.next != null){
            ptrB = ptrB.next;
            lenB++;
        }
        
        int diff = Math.abs(lenA - lenB);   //difference between the length is required to place pointers at equi distance from ends of both list
        
        ptrA = headA;
        ptrB = headB;
        while(diff != 0){
            if(lenA > lenB){
                ptrA = ptrA.next;
            } else {
                ptrB = ptrB.next;
            }
            diff--;
        }                               //pointers placed at equal distance from end of both lists
        
        
        while(ptrA.next != null && ptrB.next != null && ptrA != ptrB){  //checking if same node is found while traversing through both the lists
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if(ptrA == ptrB)            //if same node found then there is intersection between two lists
            return ptrA;
        return null;
    }
}