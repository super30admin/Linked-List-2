"""
Problem: 160. Intersection of Two Linked Lists
Leetcode: https://leetcode.com/problems/intersection-of-two-linked-lists/
Time Complexity: O(m+n), m and n are the length of two linked lists
Space Complexity: O(1), only pointers used
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # Base case
        if headA is None or headB is None:
            return None

        ptra = headA
        ptrb = headB

        while ptra != ptrb:
            if ptra == None:
                ptra = headB
            elif ptrb == None:
                ptrb = headA
            else:
                ptra = ptra.next
                ptrb = ptrb.next
        return ptra