# time complexity : 0(m+n)
#space complexity : 0(1)

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        
        curr = headA
        m = 0
        while curr is not None:
            curr = curr.next
            m = m + 1
        
        curr = headB
        n = 0
        
        while curr is not None:
            curr = curr.next
            n = n + 1
        diff = 0    
        if m > n:
            diff = m - n
            c = 0
            while c < diff:
                headA = headA.next
                c=c+1
        else:
            diff = n - m
            c = 0
            while c < diff:
                headB = headB.next
                c=c+1
        
        while headA!=headB:
            headA= headA.next
            headB = headB.next
            
        return headA
            
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        