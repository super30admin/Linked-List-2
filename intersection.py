# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        '''
        TC : O(n)
        SC : O(1)
        
        step 1 : find length of both the list
        step 2 : travese the list with greater length until we reach the same length]
        step 3 : traverse both list together to find the intersection.
        '''
        lenA = 0
        lenB = 0
        ptr = headA
        while ptr:
            lenA += 1
            ptr = ptr.next
        
        ptr = headB
        while ptr:
            lenB += 1
            ptr = ptr.next
            
        
        while lenA > lenB :
            headA =headA.next
            lenA-=1
        
        while lenB>lenA:
            headB = headB.next
            lenB -=1
        
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headA
        