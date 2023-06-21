#Time complexity = O(M+N)
#Space complexity = O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        diff = 0
        pointerA = headA
        pointerB = headB
        while(headA is not None):
            lenA+=1
            headA = headA.next
        print(lenA)
        while(headB is not None):
            lenB+=1
            headB = headB.next
        print(lenB)
        if lenA>=lenB:
            diff = lenA-lenB
        else:
            diff = lenB - lenA
        if lenA>=lenB:
            while(diff>0):
                diff-=1
                pointerA = pointerA.next
        else:
            while(diff>0):
                diff-=1
                pointerB = pointerB.next
        while(pointerA!=pointerB):
            pointerA=pointerA.next
            pointerB=pointerB.next
        return pointerA

        