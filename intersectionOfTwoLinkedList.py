
"""
Problem: Intersection of Two Linked Lists
Approach: swap heads os the two lists ehern they reach None s.t. they start at the head of the list at the same position and will meet at the Intersection
together
t.c. => O(n + m)
s.c. => O(1)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        tempB = headB
        tempA = headA

        while headA != headB:
            headA = headA.next
            headB = headB.next
            if not headA and not headB:
                return None
            if not headA:
                headA = tempB
            if not headB:
                headB = tempA
        return headA