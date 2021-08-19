"""
//Time Complexity : O(n+m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
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
        if headA == None and headB == None:
            return None
        curr = headA
        lenA = 0
        while(curr!=None):
            curr = curr.next
            lenA+=1
        curr = headB
        lenB= 0
        while(curr!=None):
            curr = curr.next
            lenB+=1
        while(lenA>lenB):
            headA=headA.next
            lenA-=1
        while(lenB>lenA):
            headB = headB.next
            lenB-=1
        while(headA!=headB):
            headA=headA.next
            headB= headB.next
        return headA
            
        # nodes=set()
        # h1=headA
        # while(h1!=None):
        #     nodes.add(h1)
        #     h1=h1.next
        # h2=headB
        # while(h2!=None):
        #     if h2 in nodes:
        #         return h2
        #     h2=h2.next
        
            
            