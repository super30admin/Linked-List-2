# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

TC:O(m+n)
SC:O(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None and headB is None:
            return None

        lenA = 0
        curr = headA
        while curr:
            curr = curr.next
            lenA += 1

        lenB = 0
        curr = headB
        while curr:
            curr = curr.next
            lenB += 1

        diff = abs(lenA - lenB)

        curr1 = None
        curr2 = None
        if lenA > lenB:
            curr1 = headA
            curr2 = headB
        else:
            curr1 = headB
            curr2 = headA

        while diff > 0:
            curr1 = curr1.next
            diff -= 1

        while curr1 is not None and curr2 is not None:
            if curr1 is curr2:
                return curr1

            curr1 = curr1.next
            curr2 = curr2.next

        return None




