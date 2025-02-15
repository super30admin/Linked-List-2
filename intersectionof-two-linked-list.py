# Time Complexity : O(m+n) - m is number of elements in the linked list A
#                            n is number of elements in the linked list B
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""

Find length of list A
Find length of list B
Move the head of bigger list by the diff in length
Now move both the heads until intersection is found

"""


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

        # find length of list A
        currA = headA
        lenA = 0

        while currA is not None:
            currA = currA.next
            lenA += 1

        # find length of list B
        currB = headB
        lenB = 0

        while currB is not None:
            currB = currB.next
            lenB += 1

            # move headA by (lenA - lenB) steps
        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        # move headB by (lenB - lenA) steps
        while lenB > lenA:
            headB = headB.next
            lenB -= 1

            # now that both the lists will have same no.of nodes from headA and headB, keep on going until we find
        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA


