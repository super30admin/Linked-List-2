# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Approach:
# 1. Use two pointers starting at the heads of the two linked lists.
# 2. Traverse both lists; when one pointer reaches the end, redirect it to the head of the other list.
# 3. If there is an intersection, the pointers will meet at the intersecting node after at most two traversals.
# 4. If no intersection exists, the pointers will both reach the end (None) at the same time.

# Time Complexity: O(m + n), where m and n are the lengths of the two linked lists.
# Space Complexity: O(1), as no additional space is used.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # If either of the heads is null, there's no intersection
        if not headA or not headB:
            return None

        # Initialize two pointers
        pointerA, pointerB = headA, headB

        # Traverse the lists
        while pointerA != pointerB:
            # If pointerA reaches the end, switch to headB; otherwise, move to the next node
            pointerA = pointerA.next if pointerA else headB

            # If pointerB reaches the end, switch to headA; otherwise, move to the next node
            pointerB = pointerB.next if pointerB else headA

        # Either both pointers meet at the intersection or both become None (no intersection)
        return pointerA
