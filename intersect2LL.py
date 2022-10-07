# TC - O(m+n)
# SC = O(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None or headB is None: return None

        # calculate length of both LL
        lenA, lenB = 0, 0

        curr = headA
        while curr is not None:
            lenA += 1
            curr = curr.next

        curr = headB
        while curr is not None:
            lenB += 1
            curr = curr.next

        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA
