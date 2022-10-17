# Time complexity: O(n)
# Space complexity: O(1)

# Code sucessfully ran on Leetcode

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None or headB == None:  return None
        
        lenA, lenB = 1, 1
        curr = headA
        
        while curr.next:
            lenA += 1
            curr = curr.next
            
        curr = headB
        while curr.next:
            lenB += 1
            curr = curr.next
            
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
            