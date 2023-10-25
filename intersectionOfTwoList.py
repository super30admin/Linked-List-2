# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        # Time: O(N)
        # Space: O(1)
        currA = headA
        countA = 0
        while currA:
            countA += 1
            currA = currA.next

        currB = headB
        countB = 0
        while currB:
            countB += 1
            currB = currB.next

        while countB > countA:
            headB = headB.next
            countB -= 1

        while countA > countB:
            headA = headA.next
            countA -= 1

        while headA and headB:
            if headA == headB: return headA
            headA = headA.next
            headB = headB.next
        return None

