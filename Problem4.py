'''
TC: O(N) {we iterate twice but linearly}
SC: O(1) {we use only constant space}

Approach: 
We first find the lengths of both linked lists, `countA` and `countB`, by traversing them from their respective heads. 
This allows us to determine which list is longer and by how many nodes.

Next, we align the starting pointers. We advance the pointer of the longer list by the difference in lengths (`abs(countA - countB)`).
This ensures that both pointers are an equal distance from the potential intersection point.
Finally, we traverse both lists simultaneously, one node at a time. We compare the pointers at each step. 
The first time the pointers are equal, we have found the intersection node, which we then return. If we reach the end of both lists without finding an intersection, we return `None`.

The problem ran successfully on LeetCode.
'''

from typing import List, Optional
# Definition for siangly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        countA, countB = 0, 0

        currA, currB = headA, headB

        while currA:
            currA = currA.next
            countA += 1
        
        while currB:
            currB = currB.next
            countB += 1

        currA, currB = headA, headB

        while countA > countB:
            currA = currA.next
            countA -= 1

        while countB > countA:
            currB = currB.next
            countB -= 1

        while currA and currB:
            if currA == currB:
                return currA
            currA = currA.next
            currB = currB.next
        
        return None