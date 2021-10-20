# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode):

        nodeB = headB
        nodeA = headA
        lengthA = 0
        lengthB = 0
        while (nodeA is not None):
            lengthA += 1
            nodeA = nodeA.next

        while (nodeB is not None):
            lengthB += 1
            nodeB = nodeB.next

        nodeB = headB
        nodeA = headA
        if lengthA > lengthB:
            while (lengthA != lengthB):
                nodeA = nodeA.next
                lengthA -= 1

        else:
            while (lengthB != lengthA):
                nodeB = nodeB.next
                lengthB -= 1

        while (nodeA is not None and nodeB is not None):
            if nodeA == nodeB:
                return nodeA

            nodeA = nodeA.next
            nodeB = nodeB.next

        return None
