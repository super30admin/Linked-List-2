# Problem 4 : Intersection of Two Linked Lists
# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # countA will store number of element of listA and countB will store number of elements in listB
        countA = 0
        countB = 0
        curr = headA
        # Count the total number of listA
        while (curr is not None):
            curr = curr.next
            countA += 1
        curr = headB
        # Count the total number of listB
        while (curr is not None):
            curr = curr.next
            countB += 1
        # if listA is bigger than listB then increment the headA till both the count is equal
        while (countA > countB):
            headA = headA.next
            countA -= 1
        # if listB is bigger than listB then increment the headB till both the count is equal
        while (countB > countA):
            headB = headB.next
            countB -= 1
        # increment both headA and headB till both are equal ie. both pointer meeting the intersection of linked list
        while (headA != headB):
            headA = headA.next
            headB = headB.next
        return headA

        