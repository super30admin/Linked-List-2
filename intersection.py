# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        countA=0
        countB=0
        tempA=headA
        tempB= headB

        while(tempA):
             countA+=1
             tempA=tempA.next

        while(tempB):
            countB+=1
            tempB = tempB.next

        while countA>countB:
            headA=headA.next
            countA-=1

        while countB>countA:
            headB=headB.next
            countB-=1

        while headA:
            if headA==headB:
                return headA
            headA=headA.next
            headB=headB.next

        
        