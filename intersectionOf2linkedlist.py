# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA, headB):
        lenA = 0
        cur = headA
        while cur != None:
            lenA += 1
            cur = cur.next
        lenB = 0
        cur = headB
        while cur != None:
            lenB += 1
            cur = cur.next

        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        while lenA < lenB:
            headB = headB.next
            lenB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA
        
#TC: O(n+m)
#SC: O(1)
        