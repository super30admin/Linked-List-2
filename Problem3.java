// Time Complexity : O(m+n) m is the Linked list A size , n is Linked list B size
// Space Complexity : O(1) , we are not storing anything here.
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach
// 3 points 
// 1. count the length of two linked list , and get the difference between them
// 2. Move the head of the longer list to different amount times, so both list become equal size.
// 3. move both head of the lists, where there are equal , it is our intersecting point.


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
        ListNode temp = headA;
        
        while(temp!=null){
            temp = temp.next;
            lenA++;
        }
        temp = headB;
        while(temp!=null){
            temp = temp.next;
            lenB++;
        }
        
        while(lenA  > lenB){
            headA = headA.next;
            lenA--;
        }
        
        while(lenB  > lenA){
            headB = headB.next;
            lenB--;
        }
            
        while(headA!= headB){
           headA = headA.next ;
           headB = headB.next;
        }
        
        return headA;
    }
}
