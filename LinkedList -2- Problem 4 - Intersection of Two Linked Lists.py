"""
FAANMG Problem #54 {Easy}

160. Intersection of Two Linked Lists

Time Complexity : O(N)


Space Complexity : O(1)


Did this code successfully run on Leetcode : Yes
  

First we find lenghth of both the linkedlist

Then match the longest len to match the shortest head
Then keep checking if the node intersect
 

@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        
        #find the length of listA
        lenA = 0
        curr = headA
        
        while(curr):
            lenA += 1
            curr =curr.next
        
        #find the length of listB
        lenB = 0
        curr = headB
        
        while(curr):
            lenB += 1
            curr =curr.next
        
        # if size of listA is bigger than listB, move the pointer of headA  till we don't have an equal list size
        while(lenA > lenB ):
            headA=headA.next
            lenA -= 1
        
        # if size of listB is bigger than listA, move the pointer of headB  till we don't have an equal list size
        while(lenA < lenB ):
            headB = headB.next
            lenB -= 1    
        
        #Compare each node, if the node is same, then intersection is printed out, else we reach null
        # when no intersection is found
        while(headA != headB):
            headA = headA.next
            headB = headB.next
            
        return headB