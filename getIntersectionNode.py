# Definition for singly-linked list.
# Time Complexity : O(n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA = 0
        lenB = 0
        p1 = headA
        p2 = headB
        while p1:
            lenA += 1
            p1 = p1.next
        while p2:
            lenB += 1
            p2 = p2.next
            
        p1 = headA
        p2 = headB
        
        while lenA != lenB:
            if lenA > lenB:
                p1 = p1.next
                lenA -= 1
            elif lenB > lenA:
                p2 = p2.next
                lenB -= 1
                
        while p1:
            if p1 == p2:
                return p1
            p1 = p1.next
            p2 = p2.next
            
        return None