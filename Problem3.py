# Time Complexity : O(n) 
# Space Complexity : O(1) (We are using only some temperory variables)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Start from the both heads, and if next is available than move one step.
# - If we reach the end, change the next to other link list's head. (By doing this we are making length for both pointer same.)
# - Run this till both nodes are not equal. and return node where both link list's element match. 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
#       Covers corner cases
        if not headA or not headB:
            return None
        first = headA
        second = headB
        
#       Run this loop while both nodes are not equal
        while first != second:
#           If element is not None move to the next node
            if first:
                first = first.next
#           If reached at the end, move to the second's head
            else:
                first = headB
#           If element is not None move to the next node
            if second:
                second = second.next
#           If reached at the end, move to the first's head
            else:
                second = headA
#       Return first or second
        return first
