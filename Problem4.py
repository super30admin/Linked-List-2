#T.C O(m + n) as there are two linkedlists
#S.C. O(n)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        bnodes = set()

        while headB is not None:
            bnodes.add(headB)
            headB = headB.next
        
        while headA is not None:
            if headA in bnodes:
                return headA
            headA = headA.next
        
        return None
