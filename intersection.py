# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # Step 1: Calculate the lengths of both lists
        def getLength(head):
            length = 0
            while head:
                length += 1
                head = head.next
            return length
        
        lenA = getLength(headA)
        lenB = getLength(headB)

        # Step 2: Align the starting points
        if lenA > lenB:
            for _ in range(lenA - lenB):
                headA = headA.next
        else:
            for _ in range(lenB - lenA):
                headB = headB.next

        # Step 3: Traverse both lists together to find the intersection
        while headA and headB:
            if headA == headB:
                return headA  # Intersection found
            headA = headA.next
            headB = headB.next

        return None  # No intersection