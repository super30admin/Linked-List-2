# Time Complexity: O(m + n), where m and n are the lengths of the two linked lists
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: No

from collections import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        # Two Pointer Approach
        lenA, lenB = 0, 0
        currA, currB = headA, headB

        # Calculate the lengths of both lists
        while currA:
            lenA += 1
            currA = currA.next

        while currB:
            lenB += 1
            currB = currB.next

        # Reset pointers to heads
        currA, currB = headA, headB

        # Advance the pointer of the longer list to align lengths
        while lenA > lenB:
            currA = currA.next
            lenA -= 1

        while lenB > lenA:
            currB = currB.next
            lenB -= 1

        # Traverse together until intersection or end
        while currA != currB:
            currA = currA.next
            currB = currB.next

        return currA

# ------------------------------------------------------------------------------------------

        # HashSet Approach
        # Time Complexity: O(m + n)
        # Space Complexity: O(m), where m is the number of nodes in list A

        # seen = set()
        # pA = headA
        # while pA:
        #     seen.add(pA)
        #     pA = pA.next

        # pB = headB
        # while pB:
        #     if pB in seen:
        #         return pB
        #     pB = pB.next

        # return None

# ------------------------------------------------------------------------------------------

        # Brute Force Approach
        # Time Complexity: O(m * n)
        # Space Complexity: O(1)

        # while headA:
        #     pB = headB
        #     while pB:
        #         if headA == pB:
        #             return headA
        #         pB = pB.next
        #     headA = headA.next

        # return None
