"""
First, I calculated the length of both linked lists, then adjusted the pointer of the longer list so that both pointers are equidistant from the end. After that, I traversed both lists together to find the intersection node.
Time Complexity: O(m + n)
Space Complexity: O(1)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lengthA = lengthB = 0
        currA = headA
        currB = headB
        while currA:
            lengthA += 1
            currA = currA.next
        while currB:
            lengthB += 1
            currB = currB.next
        while lengthA > lengthB:
            headA = headA.next
            lengthA -= 1
        while lengthB > lengthA:
            headB = headB.next
            lengthB -= 1
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA
        