/*
 * #160. Intersection of Two Linked Lists
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
Refer leetcode

begin to intersect at node c1.

 

Example 1:
Refer leetcode

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 

Example 2:
Refer leetcode

Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 

Example 3:
Refer leetcode

Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory.

 */


/*
 * Time Complexity: O (3N) = O (N) -> O (N) to find size of list A, O (N) to find size of list B, and O (N) to traverse both lists to find intersection point
 * 
 * Space Complexity: O (1) -> No extra space is used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.linkedlist2;

//Definition for singly-linked list.
class ListNode4 {
	int val; // data
	ListNode4 next;
	ListNode4() {}
	ListNode4(int val) { this.val = val; }
	ListNode4(int val, ListNode4 next)
	{
		this.val = val; 
		this.next = next; 
	}
}

public class LinkedListIntersection {
	public ListNode4 getIntersectionNode(ListNode4 headA, ListNode4 headB) {
        
        // Base condition
        if(headA == null || headB == null){
            return null;
        }
        
        // #1. Initialize the two pointers starting at head of each list A and B
        ListNode4 dummyA = headA;
        ListNode4 dummyB = headB;
        
        // #2. Initialize the size for both lists
        int sizeA = 0;
        int sizeB = 0;
        
        // #3. Find the size of list A 
        while(dummyA != null){
            sizeA += 1;
            dummyA = dummyA.next;
        }
        
        // #4. Find the size of list B
        while(dummyB != null){
            sizeB += 1;
            dummyB = dummyB.next;
        }
        
        // #5. Reset the pointers to head node
        // Since both the pointers would be at last node in each list, while finding size
        dummyA = headA;
        dummyB = headB;
        
        // #6. Make both the pointers at same level by decrementing the size and incrementing the pointer of list that has greater size than other list
        while(sizeA != sizeB){
            if(sizeA > sizeB){
                sizeA -= 1;
                dummyA = dummyA.next;
            }
            else{
                sizeB -= 1;
                dummyB = dummyB.next;
            }
        }
        
        // #7. Start traversing both the lists with dummyA and dummyB pointers at the same level to find the intersection point until we reach at null in any of the lists
        // If we reach at null w/o finding any merge point, then return null
        while(dummyA != null && dummyB != null){
            
            // If the two references(pointers) dummyA and dummyB points to the same node, we found our intersection point, return the node
            // We are not comparing for same values, but we are checking if references points to same node to find intersection point
            if(dummyA == dummyB){ 
                return dummyA;
            }
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }
        
        return null;   // no intersection point found
    }

}
