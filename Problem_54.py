# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        ll1 = headA
        ll2 = headB
        count1, count2 = 0, 0

        while ll1:
            count1 += 1
            ll1 = ll1.next

        while ll2:
            count2 += 1
            ll2 = ll2.next

        while count1 > count2:
            headA = headA.next
            count1 -= 1

        while headB and count2 > count1:
            headB = headB.next
            count2 -= 1

        while headA != headB and headA and headB:
            headA = headA.next
            headB = headB.next
        return headA