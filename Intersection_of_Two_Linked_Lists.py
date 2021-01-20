# Created by Aashish Adhikari at 2:08 PM 1/19/2021

'''
Time Complexity:
O( max (m,n)) where m and n represent the lengths from the heads to the tails of the linked lists.

Space Complexity:
O(m) since we store all nodes of the first linked list.
'''


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

        hs = set()

        while headA is not None:
            hs.add(headA)
            headA = headA.next

        while headB is not None:
            if headB in hs:
                return headB
            headB = headB.next


        return None