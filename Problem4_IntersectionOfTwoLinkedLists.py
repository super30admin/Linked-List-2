# Time Complexity : O(m + n) where m and n are lengths of the two lists
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use two pointers starting from headA and headB, switching to the other list when reaching end.
# If lists intersect, pointers will meet at intersection point after traversing (m + n) nodes total.
# If no intersection, both pointers will be None simultaneously.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None
        
        pointerA = headA
        pointerB = headB
        
        # Traverse both lists, switching to the other when reaching end
        # This ensures both pointers traverse the same total distance
        while pointerA != pointerB:
            # Move to next node, or switch to other list if at end
            pointerA = pointerA.next if pointerA else headB
            pointerB = pointerB.next if pointerB else headA
        
        # Either both are None (no intersection) or both point to intersection
        return pointerA
