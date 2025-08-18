# Time Complexity: O(m + n)
# Space Complexity: O(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # Two-pointer technique:
        # Walk pointer A through list A, pointer B through list B.
        # When a pointer hits the end, redirect it to the head of the other list.
        # If the lists intersect, the pointers will meet at the intersection node
        # after at most m+n steps (where m, n are lengths of A and B).
        # If they don't intersect, both will become None at the same time.

        startA = headA
        startB = headB

        while startA is not startB:
            startA = headB if startA is None else startA.next
            startB = headA if startB is None else startB.next

        return startA
