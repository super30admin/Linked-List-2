# Runs on Leetcode
    # Runtime - O(m+n)
    # Memory - O(1)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA and headB:
            return None
        start_A = headA
        start_B = headB
        
        while headA != headB:
            if headA is None:
                headA = start_B
            else:
                headA = headA.next
            if headB is None:
                headB = start_A
            else:
                headB = headB.next
        return headB
