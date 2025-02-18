# 160. Intersection of Two Linked Lists

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# Use two pointers to traverse the two linked lists.
# Find the length of the two linked lists.
# Traverse the longer linked list by the difference in lengths.
# Traverse both linked lists simultaneously.
# Return the node where the two linked lists intersect.


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        a,b = headA,headB
        na = nb = 0

        while a:
            a = a.next
            na+=1

        while b:
            b = b.next
            nb+=1
        
        delta = nb - na
        big = headB
        small = headA
        if na > nb:
            big = headA
            small = headB
            delta = na - nb
        
        while delta != 0:
            big = big.next
            delta -= 1

        while big != small:
            big = big.next
            small = small.next

        return small