'''
TC: O(n)
SC: O(1)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        l1, l2 = 0, 0
        fakeHead = headA
        
        while fakeHead:
            l1 += 1
            fakeHead = fakeHead.next
        
        fakeHead = headB
        
        while fakeHead:
            l2 += 1
            fakeHead = fakeHead.next
        
        if l1 > l2:
            diff = l1 - l2
            while diff > 0:
                headA = headA.next
                diff -= 1
        elif l2 > l1:
            diff = l2 - l1
            while diff > 0:
                headB = headB.next
                diff -= 1
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA
    
            
        