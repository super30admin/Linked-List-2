# TC = O(n)
# SC = O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(
        self, headA: ListNode, headB: ListNode
    ) -> Optional[ListNode]:
        currA = headA
        currB = headB
        lenA, lenB = 0, 0
        while currA:
            currA = currA.next
            lenA += 1
        while currB:
            currB = currB.next
            lenB += 1

        currA = headA
        currB = headB

        while lenB > lenA:
            currB = currB.next
            lenB -= 1

        while lenA > lenB:
            currA = currA.next
            lenA -= 1

        while currA != currB:
            currA = currA.next
            currB = currB.next

        return currA
