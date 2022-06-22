# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        curr = headA
        lenA = 0

        while curr:
            curr = curr.next
            lenA += 1

        curr = headB
        lenB = 0

        while curr:
            curr = curr.next
            lenB += 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA


# TC = O(m) + O(n).
# Space complexity : O(1). Constant. No extra space used
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
