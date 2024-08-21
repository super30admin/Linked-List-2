# time: O(n)
# space: O(1)

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def findLen(self, head):
        count = 0
        while head:
            count += 1
            head = head.next
        return count
    def getIntersectionNode(self, headA, headB):
        l1 = self.findLen(headA)
        l2 = self.findLen(headB)
        while l1 > l2:
            headA = headA.next
            l1 -= 1
        while l2 > l1:
            headB = headB.next
            l2 -= 1
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA
