# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Time Complexity --> O(m+n) where m, n are the lengths of linked lists
# Space Complexity --> O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        p1 = headA
        p2 = headB

        len1 = 0
        len2 = 0
        while p1 is not None:
            len1 += 1
            p1 = p1.next
        while p2 is not None:
            len2 += 1
            p2 = p2.next
        
        q1 = headA
        q2 = headB
        if len1-len2>0:
            for i in range(len1-len2):
                q1 = q1.next
        else:
            for i in range(len2-len1):
                q2 = q2.next 
        
        while q1 is not None and q2 is not None:
            if q1 == q2:
                return q1
            q1 = q1.next
            q2 = q2.next
        return None 
