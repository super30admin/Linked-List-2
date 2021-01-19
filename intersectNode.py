# Time complexity O(1)
# Space complexity O(m+n)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        lenA, lenB = 0, 0
        
        ptr = headA
        while(ptr):
            lenA += 1
            ptr = ptr.next
        ptr = headB
        while(ptr):
            lenB += 1
            ptr = ptr.next
        
        if lenA > lenB:
            for i in range(lenA - lenB):
                headA = headA.next
        else:
            for i in range(lenB - lenA):
                headB = headB.next
        
        while(headA != headB):
            headA = headA.next
            headB = headB.next
        
        return headA