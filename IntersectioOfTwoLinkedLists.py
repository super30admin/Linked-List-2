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
        '''Time Complexity: O(m+n)
        Space Complexity:O(1)'''
        if headA is None or headB is None:
            return
        
        #Find length of L1
        curr=headA
        lA=0
        while curr is not None:
            curr=curr.next
            lA+=1
            
        #Find length of L2
        curr=headB
        lB=0
        while curr is not None:
            curr=curr.next
            lB+=1
            
        #If L1 is larger, skin L1-L2 nodes
        while lA>lB:
            headA=headA.next
            lA-=1
        #If L2 is larger, skin L2-L1 nodes
        while lB>lA:
            headB=headB.next
            lB-=1
        #Iterator one at a time
        while headA is not headB:
            headA=headA.next
            headB=headB.next
        #return either headA OR headB
        return headA
            
            
        
