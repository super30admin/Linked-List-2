# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# Time: O(m+n)
# Space: O(1)
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        len1 = 0
        len2 = 0
        curr1 = headA
        curr2 = headB
        while curr1 != None:
            len1 += 1
            curr1 = curr1.next
        
        while curr2 != None:
            len2 += 1
            curr2 = curr2.next
        #print('eljb')
        curr1 = headA
        curr2 = headB
        #print('dkjbc')
        if len1 >= len2:
            i=0
            while i < (len1-len2):
                curr1 = curr1.next
                i += 1
            
        else:
            i=0
            while i < (len2-len1):
                curr2 = curr2.next
                i += 1
        while curr1 != None and curr2 != None:
            if curr1 == curr2:
                return curr1
            curr1 = curr1.next
            curr2 = curr2.next
        return None
            
        
        
        
        
        
