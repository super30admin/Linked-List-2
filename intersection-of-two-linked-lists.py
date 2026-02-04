''' 
Time Complexity : O(2n) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA, headB):
        # get len of linkedlist A.
        lenA = 0
        curr = headA
        while curr is not None:
            lenA += 1
            curr = curr.next
        # get len of linkedlist B.
        lenB = 0
        curr = headB
        while curr is not None:
            lenB += 1
            curr = curr.next
        # if lenA > lenB: headA -> headB lenA -= 1
        currA = headA
        while lenA > lenB:
            currA = currA.next
            lenA -= 1
        # if lenA < lenB: headB -> headA lenB -= 1
        currB = headB
        while lenB > lenA:
            currB = currB.next
            lenB -= 1
        
        # traverse headA and headB till both are same
        while currA != currB:
            currA = currA.next
            currB = currB.next
        
        return currA