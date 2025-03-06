# LL Approach
# TC - O(m+n)
# SC - O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # base case
        if headA is None or headB is None: return None

        # get lengths
        lenA = 0
        lenB = 0
        curr = headA
        while curr != None:
            lenA += 1
            curr = curr.next

        curr = headB
        while curr != None:
            lenB += 1
            curr = curr.next

        while lenA > lenB:
            headA = headA.next
            # this loop will stop when lenA = lenB
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        # now both are of same length and headA wil coincide with headB
        # This will also take care if the list never intersect
        while headA != headB:
            headA = headA.next
            headB = headB.next

        # or return headA, its the same since they've intersected
        return headB

