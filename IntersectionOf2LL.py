#TC:O(m+n)
#SC:O(1)
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
        h1=headA
        h2=headB
        lenA=0
        while(h1!=None):
            h1=h1.next
            lenA+=1
        lenB=0
        while(h2!=None):
            h2=h2.next
            lenB+=1
        h1=headA
        h2=headB
        while(lenA>lenB):
            h1=h1.next
            lenA-=1
        while(lenB>lenA):
            h2=h2.next
            lenB-=1
        while(h1!=h2):
            h1=h1.next
            h2=h2.next
        return h1
            