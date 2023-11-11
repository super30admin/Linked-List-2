# Time Complexity: O(m + n)
# Space Complexity: O(1)

# We find the lengths of the 2 Linked Lists. Once that is found, we determine which LL is longer, and move
# it to be equal to the other LL. 

# Once both are equal, we find the first Node where values are matching (or None if they don't intersect)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None and headB is None:
            return None
        
        m = n = 0
        curr = headA

        while (curr is not None):
            curr = curr.next
            m += 1
        
        curr = headB
        while (curr is not None):
            curr = curr.next
            n += 1
        
        if (m > n):
            count = m - n
            while (count > 0):
                headA = headA.next
                count -= 1
        else:
            count = n - m
            while (count > 0):
                headB = headB.next
                count -= 1
        
        while (headA != headB):
            headA = headA.next
            headB = headB.next

        return headA
