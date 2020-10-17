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
        M = 0
        A = headA
        B = headB
        while A :
            M += 1
            A = A.next
            
        
        N = 0
        while B :
            N += 1
            B = B.next
        
        if M < N :
            M , N  = N, M
            headA, headB = headB, headA
        
        
        # traverse till you hit N
        while headA and (M > N) :
            headA = headA.next
            M -= 1
            
        
        start = None
        while headA  :
            
        
            if (headA == headB) and (not start) :
                start = headA
            
            if (headA != headB) :
                start = None
    
            headA = headA.next
            headB = headB.next
        return start
                
