# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Approach 1:
# T = O(m+n)
# S = O(n)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        nodeSet = set()

        while headA != None:
            nodeSet.add(headA)
            headA = headA.next
        
        while headB != None:
            if headB in nodeSet:
                return headB
            headB = headB.next
        
# Approach 2:
# T = O(m+n)
# S = O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        # take the length of each list
        lenA = 0
        lenB = 0
        pointA = headA
        pointB = headB
        
        while pointA != None:
            lenA += 1
            pointA = pointA.next

        while pointB != None:
            lenB += 1
            pointB = pointB.next

        # set the head of the longest list to node that's equal to the difference of length

        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        
        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA # or you can return headB. It doesn't matter here
