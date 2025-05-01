# 160. Intersection of Two Linked Lists

# TC : O(m + n) where m and n are the lengths of the two lists
# SC : O(1) as we only use a constant amount of extra space
# Did this code successfully run on Leetcode : Yes

# Approach : Count the nodes in both lists to determine their lengths
# Align the pointers by advancing the pointer of the longer list, so both pointers are at the same distance from the end
# Move both pointers in tandem until they meet (intersection point) or reach the end (no intersection)
# This approach works because:
    # If the lists intersect, the pointers will meet at the intersection point after we've aligned them
    # If the lists don't intersect, both pointers will reach the end (None) at the same time


from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # Edge case: If either list is empty, there's no intersection
        if not headA or not headB:
            return None
        
        # Step 1: Count the length of both lists
        countA = 0
        countB = 0
        
        # Count nodes in list A
        currA = headA
        while currA:
            countA += 1
            currA = currA.next
        
        # Count nodes in list B
        currB = headB
        while currB:
            countB += 1
            currB = currB.next
        
        # Step 2: Reset pointers to the heads
        currA = headA
        currB = headB
        
        # Step 3: Advance the pointer of the longer list
        # This ensures both pointers will travel the same distance to the end
        while countA > countB:
            currA = currA.next
            countA -= 1
        
        while countB > countA:
            currB = currB.next
            countB -= 1
        
        # Step 4: Move both pointers until they meet
        while currA != currB:
            currA = currA.next
            currB = currB.next
        
        # Either currA is at the intersection or it's None (no intersection)
        return currA
        