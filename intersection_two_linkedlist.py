class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA, headB):
        currA = headA
        currB = headB

        while currA != currB:
            currA = currA.next
            currB = currB.next

            if currA is None and currB is None:
                return None

            if currA is None:
                currA = headB

            if currB is None:
                currB = headA

        return currA

# Time: O(m + n), where m and n are lengths of the two lists.
# Space: O(1)