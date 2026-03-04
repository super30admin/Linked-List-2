# https://leetcode.com/problems/intersection-of-two-linked-lists/

#

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        currA = headA
        currB = headB

        countA, countB = 0, 0
        
        while currA is not None:
            currA = currA.next
            countA = countA + 1

        while currB is not None:
            currB = currB.next
            countB = countB + 1

        currA = headA
        currB = headB

        while countA > countB:
            currA = currA.next
            countA = countA - 1

        while countB > countA:
            currB = currB.next
            countB = countB - 1

        while currA != currB:
            currA = currA.next
            currB = currB.next

        return currA
        

