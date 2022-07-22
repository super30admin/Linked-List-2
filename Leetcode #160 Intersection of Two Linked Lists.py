# Time Complexity: O(m+n) # m is length of first LL and n is length of second LL.
# Space Complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None or headB is None:
            return None
        
        lenA = 0
        lenB = 0
        
        while headA:
            headA = headA.next
            lenA += 1
        
        while headB:
            headB = headB.next
            lenB += 1
        
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