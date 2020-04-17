"""
## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
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


"""
class ListNode:
    def __init__(self,x):
        self.val=x
        self.next= None

def intersectingList(headA:ListNode ,headB:ListNode ):
    lenA=0
    lenB=0
    curr = headA
    while curr:    # count length of list A
        lenA += 1
        curr=curr.next

    curr =headB        # count length of list B
    while curr:
        lenB += 1
        curr=curr.next

    while lenA > lenB:   # length of A is more than move head of A to make length of A equal to B
        headA=headA.next
        lenA -= 1

    while lenB > lenA:    # length of B is more than move head of B to make length of b equal to a
        headB = headB.next
        lenB -= 1

    while headA!= headB:       # WITH EQUAL LENGTH BOTH HEAD OF A and B will meet at intersection
        headA =headA.next
        headB = headB.next
    return headA




