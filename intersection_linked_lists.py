'''
TC:O(m+n)
SC:O(1)
'''



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA, headB):
        curA, curB = headA, headB
        countA, countB = 0, 0
        while curA:
            curA = curA.next
            countA+=1
        while curB:
            curB = curB.next
            countB+=1
        
        curA, curB = headA, headB
        
        diff = abs(countA-countB)
        
        if countA > countB:
            for _ in range(diff):
                curA = curA.next
        else:
            for _ in range(diff):
                curB = curB.next
        while curA and curB:
            if curA == curB:
                return curA
            else:
                curA = curA.next
                curB = curB.next
        return None