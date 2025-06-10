'''
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null
'''

# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        pointerA, pointerB = headA, headB
        countA = countB = 0
        # get lenghts
        while pointerA:
            pointerA = pointerA.next
            countA += 1
        while pointerB:
            pointerB = pointerB.next
            countB += 1
        # get difference, then move pointer to the beginning positions & move longer list pointer to equidistant position
        if countA > countB:
            difference = countA-countB
            pointerA, pointerB = headA, headB
            while difference > 0:
                pointerA = pointerA.next
                difference -= 1

        else:
            difference = countB-countA
            pointerA, pointerB = headA, headB
            while difference > 0:
                pointerB = pointerB.next
                difference -= 1
        while pointerA != pointerB:
            pointerA = pointerA.next
            pointerB = pointerB.next
        return pointerB