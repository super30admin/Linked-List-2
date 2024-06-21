'''
## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: No

'''

# Definition for singly-linked list.
# class ListNode:
#   def __init__(self, x):
#     self.val = x
#     self.next = None

class Solution:
  def getIntersectionNode(self, headA, headB):
    # get the size of A and B
    sizeA = 0
    sizeB = 0
    nodeA = headA
    nodeB = headB
    while nodeA:
      sizeA += 1
      nodeA = nodeA.next
    while nodeB:
      sizeB += 1
      nodeB = nodeB.next

    # identify the longer and shorter linked list
    shorter = None
    longer = None
    if sizeA <= sizeB:
      shorter, longer = headA, headB
    else:
      shorter, longer = headB, headA

    # get the size difference and skip those many initial nodes of the longer linked list to match the starting positions
    difference = abs(sizeA - sizeB)
    for i in range(difference):
      longer = longer.next

    # move both pointers by one node till the end, if they meet that's the intersection
    while shorter:
      if shorter == longer:
        return shorter
      shorter = shorter.next
      longer = longer.next

    # if pointers reache the end without meeting that means there is no intersection
    return None
