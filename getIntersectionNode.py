# Time Complexity : O(n) where n is the larger of the two linkedlists
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        hashA = set()
        pointerA = headA
        while pointerA:
            hashA.add(pointerA)
            pointerA = pointerA.next
        pointerB = headB
        while pointerB:
            if pointerB in hashA:
                return pointerB
            pointerB = pointerB.next
        return None
