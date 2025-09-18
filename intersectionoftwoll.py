# Time Complexity : O(N) where N is the number of nodes in the linked list
# Space Complexity : O(1) as we only use a constant amount of extra space for pointers
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# We will use two pointers to traverse the two linked lists.
# When one pointer reaches the end of its list, we will redirect it to the head of the other list.
# If the two lists intersect, the pointers will meet at the intersection node after at most 2 passes.
# If the two lists do not intersect, both pointers will reach the end (None) at the same time.

from typing import Optional
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        nextA = headA
        nextB = headB
        while nextA != nextB:
            nextA = headB if nextA is None else nextA.next
            nextB = headA if nextB is None else nextB.next

        return nextA

        
        