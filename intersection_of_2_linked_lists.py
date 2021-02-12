'''
Time complexity: O(m+n)
Space complexity: O(1)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        sizeA = 0
        sizeB = 0
        dummyA = headA
        dummyB = headB
        
        while dummyA:
            dummyA = dummyA.next
            sizeA = sizeA + 1
        while dummyB:
            dummyB = dummyB.next
            sizeB = sizeB + 1
        
        dummyA = headA
        dummyB = headB
        if sizeA > sizeB:
            while sizeA != sizeB:
                sizeA = sizeA - 1
                dummyA = dummyA.next
        else:
            while sizeA != sizeB:
                sizeB = sizeB - 1
                dummyB = dummyB.next
        
        while dummyA and dummyB and dummyA != dummyB:
            dummyA = dummyA.next
            dummyB = dummyB.next
        
        return dummyA
                