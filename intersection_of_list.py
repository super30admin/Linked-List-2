"""
Approach1: use hset to save one of the lists and traverse the other list while searching for the node in hset.
The first node found is the intersection node.
TC: O(m+n) and SC:O(m+n)

Approach2: Find the length of each list, move the longer list by (len_long_list - len_short_list),so that the
pointers can start from the same node such that when moved by 1 step meet at intersection.
"""

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode_bruteForce(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        hset = set()

        currA = headA
        while currA:
            hset.add(currA)
            currA = currA.next

        currB = headB
        while currB:
            if currB in hset:
                return currB
            currB =currB.next

        return None

    def getIntersectionNode_space_optimized(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return headA

        lenA = 0
        lenB = 0
        currA = headA
        currB = headB

        # find the lenght of both lists
        while currA:
            lenA += 1
            currA = currA.next

        while currB:
            lenB += 1
            currB = currB.next

        # move the longer LL
        currA = headA
        currB = headB
        count = abs(lenA - lenB)
        if lenA > lenB:
            while count > 0:
                currA = currA.next
                count -= 1
        else:
            while count > 0:
                currB = currB.next
                count -= 1

        while (currB and currA):
            if currB == currA:
                return currB
            currB = currB.next
            currA = currA.next

        return None



