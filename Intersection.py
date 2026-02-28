# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Count the lengths of both lists.
# Move the longer list ahead to match the length.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        currA, currB = headA, headB
        countA, countB = 0,0 

        while currA:
            currA = currA.next
            countA += 1

        while currB:
            currB = currB.next
            countB += 1

        currA = headA
        currB = headB

        while countA > countB:
            currA = currA.next
            countA -= 1

        while countB > countA:
            currB = currB.next
            countB -= 1

        while currA != currB:
            currA = currA.next
            currB = currB.next

        return currA
                
        