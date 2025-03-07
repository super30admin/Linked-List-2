"""
## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    #TC: O(n+m) SC: O(n)
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None: return headB
        if headB is None: return headA

        box = set()

        currA = headA

        while currA:
            box.add(currA)
            currA = currA.next

        currB = headB

        while currB:
            if currB in box:
                return currB
            currB = currB.next

        return None


# Approach -2 two pointers

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# TC: O(N) SC: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None  # No intersection if either list is empty

        # Find the lengths of both lists
        lenA, lenB = self.getLength(headA), self.getLength(headB)
        
        # Align the starting points of both lists
        if lenA > lenB:
            headA = self.advanceBy(headA, lenA - lenB)
        else:
            headB = self.advanceBy(headB, lenB - lenA)

        # Traverse both lists together to find the intersection
        while headA and headB:
            if headA == headB:
                return headA  # Intersection found
            headA, headB = headA.next, headB.next

        return None  # No intersection

    def getLength(self, head: ListNode) -> int:
        length = 0
        while head:
            length += 1
            head = head.next
        return length

    def advanceBy(self, head: ListNode, steps: int) -> ListNode:
        while steps > 0:
            head = head.next
            steps -= 1
        return head


        