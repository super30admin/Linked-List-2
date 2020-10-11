class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None
        ptrA =headA
        ptrB =headB
        while ptrA != ptrB:
            if ptrA == None:
                ptrA = headB
            elif ptrB == None:
                ptrB = headA
            else:
                ptrA = ptrA.next
                ptrB = ptrB.next
        return ptrA
        
        # ptrA behind ptrB and vice versa else traverse both, tc linear, sc constant.
