'''
TC: O(n)
SC: O(1)
'''
# Definition for singly-linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        dummy = ListNode(-1, head)
        s,f = dummy,dummy
        while f and f.next:
            s = s.next
            f = f.next.next
        f = s.next
        s.next = None
        prev = None
        curr = f
        while curr:
            f = f.next
            curr.next = prev
            prev = curr
            curr = f
        c,s = dummy.next, dummy.next
        f = prev
        while f:
            s = s.next
            c.next = f
            c = c.next
            f = f.next
            c.next = s
            c = s
        return dummy.next