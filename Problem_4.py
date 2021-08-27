# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    """
    TC - O(m+n)
    SC - O(1)
    """
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        lenA, lenB = 0 , 0
        cur = headA
        while cur != None:
            cur = cur.next
            lenA += 1
        cur = headB
        while cur != None:
            cur = cur.next
            lenB += 1
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headB