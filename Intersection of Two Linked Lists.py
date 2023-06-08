# Time Complexity: O(n)
# Space Complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA, lenB = 0, 0
        tempA, tempB = headA, headB
        while tempA:
            lenA += 1
            tempA = tempA.next
        while tempB:
            lenB += 1
            tempB = tempB.next
        # print(lenA, lenB)

        tempA, tempB = headA, headB

        if lenA > lenB:
            jumps = lenA - lenB
            while jumps > 0:
                tempA = tempA.next
                jumps -= 1

        if lenB > lenA:
            jumps = lenB - lenA
            while jumps > 0:
                tempB = tempB.next
                jumps -= 1

        while tempA and tempB and tempA != tempB:
            tempA = tempA.next
            tempB = tempB.next
        return tempA