# Time complexity: O(n)
# Space Complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        curr = headA
        lenA = 0
        
        while(curr):
            lenA += 1
            curr = curr.next
        
        curr = headB
        lenB = 0
        
        while(curr):
            lenB+= 1
            curr = curr.next
        
        while(lenA>lenB):
            headA = headA.next
            lenA -= 1
        
        while(lenB>lenA):
            headB = headB.next
            lenB -= 1
        
        # Both are equidistant from intersection point
        
        while(headA != headB):
            headA = headA.next
            headB = headB.next
        
        return headA
        
        