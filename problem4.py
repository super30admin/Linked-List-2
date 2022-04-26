'''https://leetcode.com/problems/intersection-of-two-linked-lists/'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


# Time Complexity : O(N) all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None or headB is None: return None
        
        # get lenA
        lenA = 0
        p = headA
        while p is not None:
            lenA += 1
            p = p.next
        
        # get lenB
        lenB = 0
        p = headB
        while p is not None:
            lenB += 1
            p = p.next
        
        a = headA
        while lenA > lenB:
            a = a.next
            lenA -= 1
        
        b = headB
        while lenB > lenA:
            b = b.next
            lenB -= 1
        
        while a is not b:
            a = a.next
            b = b.next
        
        return a
            
        
        
        
        
        
        
        