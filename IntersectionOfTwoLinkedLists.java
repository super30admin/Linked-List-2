// Time Complexity : O(m+n), where m is length of list A, n is length of list B
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took the idea from class

// Your code here along with comments explaining your approach
// Main idea is if we calculate the length of the two linkedlists, initialize two pointers at the head for the shorter list and at head+difference for the longer list 
// both will meet at the point of intersection
// the approach discussed in class actually sets the pointer to the head of the other list as it reaches null and both the pointers would reach the node of intersection at the same time 

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        while(ptrA!=ptrB){
            if(ptrA==null) ptrA = headB;
            else if(ptrB==null) ptrB = headA;
            else{
                ptrA = ptrA.next;
                ptrB = ptrB.next;                
            }
        }
        
        return ptrA;
    }
}