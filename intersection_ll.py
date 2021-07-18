
#Time Complexity: O(N+M).
#Auxiliary Space: O(1)
#Did this code successfully run on Leetcode :Yes


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
        len_a = 0
        len_b = 0
        curr = headA
        while(curr):
            len_a+=1
            curr = curr.next
        curr = headB
        while(curr):
            len_b+=1
            curr = curr.next
        if len_a==0 or len_b==0:
            return None
        p1 = headA
        p2 = headB
        if len_a>len_b:
            diff = len_a-len_b
            while(diff>0):
                p1=p1.next
                diff-=1
        elif len_a <len_b:
            diff = len_b - len_a
            while(diff >0):
                p2=p2.next
                diff-=1
        while(p1 and p2):
            if p1==p2:
                return p1
            p1 = p1.next
            p2 = p2.next
        return None