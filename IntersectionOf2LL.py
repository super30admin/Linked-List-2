# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition is here to calculate the length of each LL to determine the difference in length so that to have the
# pointer from the start for both list

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = lenB = 0
        curr = headA
        while curr != None:
            lenA += 1
            curr = curr.next

        curr = headB
        while curr != None:
            lenB += 1
            curr = curr.next

        p1 = headA
        p2 = headB
        if lenA > lenB:
            diff = lenA - lenB
            while diff > 0:
                p1 = p1.next
                diff -= 1
        else:
            diff = lenB - lenA
            while diff > 0:
                p2 = p2.next
                diff -= 1

        while p1 != p2:
            p1 = p1.next
            p2 = p2.next

        return p1
