#Time Complexity: O(n)
#Space Complexity: O(1)

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
        currA, currB = headA, headB
        while currA != currB:
            currA, currB = currA.next, currB.next
            if currA is None and currB is None: return None
            if currA is None: currA = headB
            elif currB is None: currB = headA
        return currA
        