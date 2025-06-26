# Time Complexity : O(m + n), where m and n are the lengths of listA and listB respectively
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # I use two pointers that switch heads when they reach the end.
        # If there's an intersection, they'll meet there after at most m + n steps.
        if not headA or not headB:
            return None

        a, b = headA, headB

        while a != b:
            a = a.next if a else headB
            b = b.next if b else headA

        return a
