# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = lenB = 0
        auxHeadA = headA
        auxHeadB = headB
        while auxHeadA != None:
            auxHeadA = auxHeadA.next
            lenA += 1
        while auxHeadB != None:
            auxHeadB = auxHeadB.next
            lenB += 1
        
        if lenA > lenB:
            longHead = headA
            shortHead = headB
        else:
            longHead = headB
            shortHead = headA
        
        lenDiff = abs(lenA-lenB)

        while lenDiff > 0:
            longHead = longHead.next
            lenDiff -= 1
        
        while longHead!= None and shortHead!=None:
            if longHead == shortHead:
                return longHead
            longHead = longHead.next
            shortHead = shortHead.next
        
        return None

#TC 1 = [2,6,4], [1,5] no interesct
#auxHA = 6, c = 1, aHA = 4, c = 2, c = 3
# lA = 3, lB = 2, diff = 1, 

        