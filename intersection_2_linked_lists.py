# TC - O(n+m)
# SC - O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # First get the length of both linked lists
        lenA, lenB = 0, 0
        tempA, tempB = headA, headB
        
        while tempA:
            lenA += 1
            tempA = tempA.next
        
        while tempB:
            lenB += 1
            tempB = tempB.next
        
        # Now Align both the head pointers 
        while lenA > lenB:
            headA = headA.next
            lenA-=1
        
        while lenB > lenA:
            headB = headB.next
            lenB-=1
        
        # Now Iterate over headA and headB until not None
        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        
        return None


        