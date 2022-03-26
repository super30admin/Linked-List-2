# Time Complexity : O(N+M)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
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
        lenA = 0
        lenB = 0
        curr_node_a = headA
        curr_node_b = headB
        while curr_node_a != None:
            lenA += 1
            curr_node_a = curr_node_a.next
            
        while curr_node_b != None:
            lenB += 1
            curr_node_b = curr_node_b.next
        
        curr_node_a = headA
        curr_node_b = headB
        
        if lenA > lenB:
            for i in range(lenA - lenB):
                curr_node_a = curr_node_a.next
        else:
            for i in range(lenB - lenA):
                curr_node_b = curr_node_b.next
        
        while  curr_node_b != curr_node_a:
                curr_node_b = curr_node_b.next
                curr_node_a = curr_node_a.next
                
        return curr_node_b 
            
            
                
            
            
        