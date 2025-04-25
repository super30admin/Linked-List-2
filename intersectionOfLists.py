# Approach: Two-pointer technique. Traverse both lists; when reaching the end, switch heads.
# This equalizes the length traversed if there's an intersection.
# Time Complexity: O(m + n), where m and n are the lengths of the two linked lists.
# Space Complexity: O(1), uses constant space.

from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getIntersectionNode(
        self, headA: Optional[ListNode], headB: Optional[ListNode]
    ) -> Optional[ListNode]:
        if not headA or not headB:
            return None

        # Initialize two pointers at the start of both lists
        ptrA, ptrB = headA, headB

        # Traverse the lists
        while ptrA != ptrB:
            # If end of list A is reached, redirect to head of list B
            ptrA = ptrA.next if ptrA else headB
            # If end of list B is reached, redirect to head of list A
            ptrB = ptrB.next if ptrB else headA

        # Either the intersection node or None
        return ptrA


common = ListNode(8)
a = ListNode(3)
a.next = common
b = ListNode(1)
b.next = common

res = Solution().getIntersectionNode(a, b)
print("Intersection at node with value:", res.val if res else "No intersection")
