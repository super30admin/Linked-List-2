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
        if not headA or not headB:
            return None

        lenA = self._get_length(headA)
        lenB = self._get_length(headB)

        currA = headA
        currB = headB

        if lenA > lenB:
            diff = lenA - lenB
            for _ in range(diff):
                currA = currA.next
        else:
            diff = lenB - lenA
            for _ in range(diff):
                currB = currB.next

        while currA and currB:
            if currA == currB:
                return currA  
            currA = currA.next
            currB = currB.next


        return None

    def _get_length(self, head):
        length = 0
        while head:
            length += 1
            head = head.next
        return length
