#LC 160 - Intersection of Two Linked Lists
#Time Complexity - O(len(A) + len(B))
#Space Complxity - O(1)
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
        lA = 0
        lB = 0
        ta = headA
        tb = headB
        while ta:
            lA = lA + 1
            ta = ta.next
        while tb:
            lB = lB + 1
            tb = tb.next
        if lA > lB:
            while lA > lB:
                headA = headA.next
                lA = lA - 1
        else:
            while lA < lB:
                headB = headB.next
                lB = lB - 1
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA