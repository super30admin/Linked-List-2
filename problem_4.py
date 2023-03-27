# Time Complexity - O(n)
# Space Complexity - O(1)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1 = 0 
        l2 = 0 
        currA = headA
        currB = headB
       
        while currA : 
            l1 += 1 
            currA = currA.next 
        while currB : 
            l2 += 1 
            currB = currB.next        
        while l1>l2 :
             headA = headA.next 
             l1 -= 1
        while l2>l1:
             headB = headB.next 
             l2 -= 1 
        while headA != headB : 
            headA = headA.next 
            headB = headB.next 

        return headA


        
        
            
        