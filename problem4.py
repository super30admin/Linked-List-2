# https://leetcode.com/problems/intersection-of-two-linked-lists/


# Time Complexity : O(N) where N is number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach

# Approach : We find the total length of both linked lists. We find the difference between them and move the longer list
# pointer by difference. Now we are aware that both the lists are of same size. we keep moving both the pointers at a
# until they meet each other. If yes we return that node else we return none.

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        cur = headA
        lenA, lenB = 0, 0
        while cur is not None:
            cur = cur.next
            lenA += 1

        cur = headB
        while cur is not None:
            cur = cur.next
            lenB += 1

        other = None
        print(lenA, lenB)
        if lenA < lenB:
            cur = headB
            other = headA
        else:
            cur = headA
            other = headB

        dif = abs(lenA - lenB)
        while dif != 0:
            cur = cur.next
            dif -= 1

        while cur != other and cur is not None:
            cur = cur.next
            other = other.next

        return cur
