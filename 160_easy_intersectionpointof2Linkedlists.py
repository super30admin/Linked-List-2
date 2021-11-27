# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # s30 solution constant memory two pass  (o)n time
        # """
        #  Take out the lengths of the linked lists,move the head pointer
        #  of the longer string at the position of the head of
        #  smaller linked list and then just move both the lists at 1x
        #  speed, the meeting point will be the intersection
        #
        lengthA = 0
        curr = headA
        while curr:
            curr = curr.next
            lengthA += 1
        lengthB = 0
        curr = headB
        while curr:
            curr = curr.next
            lengthB += 1
        while lengthA > lengthB:
            headA = headA.next
            lengthA -= 1
        while lengthB > lengthA:
            headB = headB.next
            lengthB -= 1
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA

        # brute force below
        """Compare every node of a with node of b linkedlist"""
        ####
#         currha=headA
#         while currha:
#             currhb=headB
#             while currhb:
#                 if currha==currhb:
#                     return currha
#                 currhb=currhb.next

#             currha=currha.next
#         return None

        """fastest below still to understand third approach"""

        # class Solution:
        #     def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        #         pa = headA
        #         pb = headB
        #         while pa != pb:
        #             pa = headB if pa is None else pa.next
        #             pb = headA if pb is None else pb.next
        #         return pa




