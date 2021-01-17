# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Two Pointer Approach. Set both the pointers at each head. While the pointers are not equal traverse the list until it reaches end of list
# Then set the pointer to opposite head once they reach the end of the list
# When they are equal return any of the pointer

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode,
                            headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        pointer1 = headA
        pointer2 = headB
        while pointer1 != pointer2:
            if not pointer1:
                pointer1 = headB
            else:
                pointer1 = pointer1.next
            if not pointer2:
                pointer2 = headA
            else:
                pointer2 = pointer2.next
        return pointer1
