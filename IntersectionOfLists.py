# Time Complexity : O(m+n) where m is the length of the first list and n is the length of the second list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        currA = headA
        currB = headB
      
        while currA != currB:
            currA = currA.next
            currB = currB.next
            if currA is None and currB is None:
                return None
            if currA is None:
                currA = headB
            if currB is None:
                currB = headA
        return currA