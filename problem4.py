'''
Time Complexity: O(m+n) -> m is length of headA , n is length of headB
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation : Find the length of A and length B, then make the list which is smaller move faster so that both lists
move at the same time and find the intersection.
'''


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def move(self, curr: ListNode, length: int) -> ListNode:

        while length > 0:
            curr = curr.next
            length -= 1
        return curr

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        cursorA = headA
        lengthA = 0
        cursorB = headB
        lengthB = 0
        while cursorA != None:
            lengthA += 1
            cursorA = cursorA.next

        while cursorB != None:
            lengthB += 1
            cursorB = cursorB.next

        if lengthA > lengthB:
            diff = lengthA - lengthB
            cursorA = self.move(headA, diff)
            cursorB = headB
        else:
            diff = lengthB - lengthA
            cursorB = self.move(headB, diff)
            cursorA = headA

        while cursorA != None and cursorB != None:

            if cursorA == cursorB:
                return cursorA
            cursorA = cursorA.next
            cursorB = cursorB.next

        return None

