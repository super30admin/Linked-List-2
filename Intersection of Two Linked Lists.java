/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 

Example 2:


Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 

Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/


//T: O(n)
//S: O(1)
//Get the difference in the length and move the larget list first to make sure both the list have same start point

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
        
        ListNode headOfA = headA;
        ListNode headOfB = headB;
        int countA = 1, countB = 1;
        
        while(headOfA.next != null){
            countA++;
            headOfA = headOfA.next;
        }
        
        while(headOfB.next != null){
            countB++;
            headOfB = headOfB.next;
        }
        
        if(headOfA != headOfB)  return null; //if Last node is not common
        
        ListNode largerList = (countA > countB) ? headA : headB;
        ListNode smallerList = (countA > countB) ? headB : headA;
        
        int diffLength = Math.abs(countA - countB);
        
        while(diffLength > 0){
            diffLength--;
            largerList = largerList.next;
        }
        
        while(largerList != null || smallerList != null){
            
            if(largerList == smallerList)   return largerList;
            largerList = largerList.next;
            smallerList = smallerList.next;
        } 
        
        return null;
        
    }
}

// T: O(n)
// S: O(1)
// we will reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node. 
// In the second iteration, we will move two pointers until they points to the same node. Our operations in first iteration will help us counteract the difference. 
// So if two linkedlist intersects, the meeting point in second iteration must be the intersection point. 

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
        
        ListNode headOfA = headA;
        ListNode headOfB = headB;
        
        while(headOfA != headOfB){
            
            if(headOfA == null)  headOfA = headB;
            else headOfA = headOfA.next;
            
            if(headOfB == null)  headOfB = headA;
            else headOfB = headOfB.next;
            
        }
        
        return headOfA;

    }
}


