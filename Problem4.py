'''
Time Complexity: O(m+n)
Space Complexity: O(1)
Run on Leetcode: YES
'''
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        posA = headA
        posB = headB
        a = headA
        b = headB
        while(posA != None and posB != None):
            posA = posA.next
            posB = posB.next
            
        if posA != None:
            while(posA != None):
                posA = posA.next
                a = a.next
            
        else:
            while(posB != None):
                posB = posB.next
                b = b.next
                
        while(a != None):
            if a == b:
                return a
            a = a.next
            b = b.next
        return None