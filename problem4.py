#intersection of two linked list

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        A = headA
        B = headB
        while A!=B:
            A = headB if A is None else A.next
            B = headA if B is None else B.next
        
        return A
        