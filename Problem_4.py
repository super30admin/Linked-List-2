# https://leetcode.com/problems/intersection-of-two-linked-lists/description/

# Time complexity: O(n + m) 
# Space complexity: O(1)
# Explanation: Two pointers starting at each list. When one reaches the end, redirect it to the other list's head. 
# This makes both pointers traverse the same total distance, automatically compensating for the difference in list lengths. 
# They either meet at the intersection or both become None.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        first, second = headA, headB
        while first != second:
           first = headB if first is None else first.next
           second = headA if second is None else second.next
        
        return first
        
