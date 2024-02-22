# Definition for singly-linked list.
from typing import Optional

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        s,f = headA, headB
        
        while s!=f:
            if s == f:
                return s
            s = headB if not s else s.next
            f = headA if not f else f.next
        return s