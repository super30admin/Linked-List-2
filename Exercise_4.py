# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


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
        if headA == None or headB == None:
            return None
        
        len1 = 0
        len2 = 0
        
        curr = headA
        
        while curr:
            len1+=1
            curr = curr.next
            
        curr = headB
        
        while curr:
            len2+=1
            curr = curr.next
            
        while len1>len2:
            headA = headA.next
            len1-=1
        
        while len2>len1:
            headB = headB.next
            len2-=1
            
        while headA!=headB:
            headA = headA.next
            headB = headB.next
            
        return headA