#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        A = headA
        B = headB
        while A and B:
            A = A.next
            B = B.next
        while A:
            A = A.next
            headA = headA.next
        while B:
            B = B.next
            headB = headB.next
        while headA!=headB:
            headA = headA.next
            headB = headB.next
        return headA
