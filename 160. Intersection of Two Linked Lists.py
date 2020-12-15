# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
#O(m+n)>>O(N)
#O(1)
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        lA=headA
        lB=headB
        #same as making the smaller list pointer advance ahead by (difference in length) steps 
        
        while lA!=lB:
            if lA:
                lA=lA.next
            else:
                lA=headB
            if lB:
                lB=lB.next
            else:
                lB=headA
        return lB
            
            
            
            
            