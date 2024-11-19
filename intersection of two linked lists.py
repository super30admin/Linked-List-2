#TC: O(m+n)
#SC: O(1) 
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return
        
        countA = 0
        countB = 0
        tempA = headA
        tempB = headB
        while tempA:
            countA += 1
            tempA = tempA.next
        while tempB:
            countB += 1
            tempB = tempB.next

        diff = abs(countA-countB)

        currA = headA
        currB = headB
        counter = 0
        if countA >= countB:
            while counter < diff:
                currA = currA.next
                counter += 1
        else:
            while counter < diff:
                currB = currB.next
                counter += 1

        while currA and currB:
            if currA == currB:
                return currA
            currA = currA.next
            currB = currB.next
        return
