# Time complexity is O(n) n is the size of the bigger linked list
# space compexity is O(1)


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        aListCount = 0
        bListCount = 0

        nodeA = headA
        nodeB = headB

        while nodeA:
            aListCount += 1
            nodeA = nodeA.next

        while nodeB:
            bListCount += 1
            nodeB = nodeB.next

        nodeA = headA
        nodeB = headB

        while nodeA != nodeB:
            if aListCount > bListCount:
                nodeA = nodeA.next
                aListCount -= 1

            elif aListCount < bListCount:
                nodeB = nodeB.next
                bListCount -= 1
            else:
                nodeA = nodeA.next
                nodeB = nodeB.next

        return nodeA
