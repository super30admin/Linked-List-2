#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
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
        if(headA==None or headB==None ):
            return None
            
        p1=headA
        p2=headB
        
        while(p1!=p2):
            p1=p1.next
            p2=p2.next
            
            if(p1==p2):
                return p1
            
            if(p1==None):
                p1=headB
            
            if(p2==None):
                p2=headA
        
        return p2
        