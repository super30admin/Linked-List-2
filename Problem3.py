# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lA = 0
        lB = 0
        curr = headA
        while curr is not None:
            curr = curr.next
            lA += 1

        curr = headB
        while curr is not None:
            curr = curr.next
            lB += 1
        
        while lB > lA:
            headB = headB.next
            lB -= 1

        while lA > lB:
            headA = headA.next
            lA -= 1
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA