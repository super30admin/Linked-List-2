# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    # T: O(m + n), S: O(1)


class Solution:
    def getIntersectionNode(
        self, headA: ListNode, headB: ListNode
    ) -> Optional[ListNode]:
        # Helper function to calculate the length of a linked list
        def getLength(head):
            length = 0
            while head:
                length += 1
                head = head.next
            return length

        # Get the lengths of both lists
        lenA = getLength(headA)
        lenB = getLength(headB)

        # Find the difference in lengths
        diff = abs(lenA - lenB)

        # Align the pointers
        if lenA > lenB:
            for _ in range(diff):
                headA = headA.next
        else:
            for _ in range(diff):
                headB = headB.next

        # Traverse both lists together to find the intersection
        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

        return None
