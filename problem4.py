# Time Complexity: O(m+n) m:length of headA n:length of headB
# Space Complexity: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = self.get_length(headA)
        lenB = self.get_length(headB)

        diff = abs(lenA - lenB)

        if lenA > lenB:
            for _ in range(diff):
                headA = headA.next
        else:
            for _ in range(diff):
                headB = headB.next

        while headA and headB:
            if headA == headB:
                return headA
            else:
                headA = headA.next
                headB = headB.next

        return None

    def get_length(self, head):
        count = 0
        itr = head
        while itr:
            count += 1
            itr = itr.next
        return count