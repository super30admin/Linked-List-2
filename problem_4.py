"""
problem 4: Intersection of Two Linked Lists
TC: O(n)
Sc : O(1)
Approach:
1. Find the length of both the linked lists
2. Traverse the longer linked list by the difference of the lengths of the two linked lists
3. Traverse both the linked lists until we find the intersection node
4. If no intersection node is found, return None
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None

        curr = headA
        lenA = 0
        while curr:
            curr = curr.next
            lenA += 1

        curr = headB
        lenB = 0
        while curr:
            curr = curr.next
            lenB += 1

        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        while lenA < lenB:
            headB = headB.next
            lenB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA
