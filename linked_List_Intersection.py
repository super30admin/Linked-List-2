# Leetcode 153. Find Minimum in Rotated Sorted Array

# Time Complexity :  O(m+n) where m,n are the length of the two lists

# Space Complexity : O(1) 

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Calculate length of the two lists using to pointers, Move the pointer of the larger list by
# the difference of both lists so that they reach the intersection at same time while moving at 1x speed.
# Once the pointers point to same node, then intersection is found and return any pointer.

# Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA = 0
        lenB = 0
        # Pointer to calculate the len of list A
        curr = headA
        while curr:
            curr = curr.next
            lenA += 1
        # reset Pointer to calculate the len of list B    
        curr = headB
        while curr:
            curr = curr.next
            lenB += 1
        # Using len adjust the head of larger list to match the len of smaller list    
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        while lenA < lenB:
            headB = headB.next
            lenB -= 1
        # Move heads of both lists until they match and give point of intersection and return any head
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA