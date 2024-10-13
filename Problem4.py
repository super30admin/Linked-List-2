# Time Complexity = O(m+n) | Space Complexity = O(1)

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        currA = headA
        currB = headB
        countA = 0
        countB = 0
        # finding len of linked lists
        while currA is not None:
            currA = currA.next
            countA += 1
        while currB is not None:
            currB = currB.next
            countB += 1

        # moving both the pointers back to starting
        currA = headA
        currB = headB
        # moving pointer of biggest len linked list to match 2nd list
        while countA > countB:
            currA = currA.next
            countA -= 1

        while countB > countA:
            currB = currB.next
            countB -= 1
        # when both the pointers move return the intersection
        while currA != currB:
            currA = currA.next
            currB = currB.next

        return currA


