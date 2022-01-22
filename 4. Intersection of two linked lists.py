class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # Time Complexity = O(m+n)
        # Space Complexity = O(1)
        if headA is None or headB is None:
            return None

        # Get lengths of both the lists
        lenA = 0
        curr = headA
        while curr is not None:
            curr = curr.next
            lenA += 1
        lenB = 0
        curr = headB
        while curr is not None:
            curr = curr.next
            lenB += 1

        # Adjusting the lengths of the linked list to be the same
        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        # Traversing the lists in sync
        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA


