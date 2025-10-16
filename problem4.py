# Time Complexity : O(m + n) — where m and n are the lengths of the two linked lists.
#                    Each pointer traverses both lists once at most.
# Space Complexity : O(1) — no extra space is used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially understanding 
# how switching heads aligns traversal lengths of both lists.


# Your code here along with comments explaining your approach
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # Initialize two pointers for both lists
        left, right = headA, headB

        # Continue until both pointers are equal (either at intersection or both None)
        while left != right:
            # Move each pointer forward
            left = left.next
            right = right.next

            # If both reach the end (None) at the same time — no intersection
            if left is None and right is None:
                return None

            # If one pointer reaches the end first,
            # redirect it to the head of the other list
            if left is None:
                left = headB
            if right is None:
                right = headA

        # When they meet, it's either the intersection node or None (if no intersection)
        return left