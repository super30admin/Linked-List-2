# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        dummyA = headA
        dummyB = headB
        sizeA = 0
        sizeB = 0
        
        while(dummyA):
            sizeA += 1
            dummyA = dummyA.next
        
        while(dummyB):
            sizeB += 1
            dummyB = dummyB.next
            
        dummyA = headA
        dummyB = headB
        
        if(sizeA > sizeB):
            while(sizeA != sizeB):
                dummyA = dummyA.next
                sizeA -= 1
        
        if(sizeB > sizeA):
            while(sizeA != sizeB):
                dummyB = dummyB.next
                sizeB -= 1
        
        while(dummyA and dummyB):
            if(dummyA == dummyB):
                return dummyA
            else:
                dummyA = dummyA.next
                dummyB = dummyB.next
        
        return None
