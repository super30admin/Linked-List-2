# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(
        self, headA, headB
    ):
        currA, currB = headA, headB
        while currA != currB:
            if currA == currB:
                return currA
            if currA:
                currA = currA.next
            else:
                currA = headB
            if currB:
                currB = currB.next
            else:
                currB = headA
        return currA
