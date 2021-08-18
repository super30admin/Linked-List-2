"""
Time Complexity : O(m + n) where m is length of listA and n is length of listB
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        pointerA = headA
        pointerB = headB
        # Incremenet both the pointer till pointerB is null reset it to headA
        # increment both pointers again till A reaches end then reset A to B and 
        # pointer B to its head
        while pointerA != pointerB:
            if pointerB is None:
                pointerB = headA
            else:
                pointerB = pointerB.next
            if pointerA is None:
                pointerA = headB
            else:
                pointerA = pointerA.next
        return pointerA