# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        
        counterA, counterB = 0, 0
        countA, countB = headA, headB
        while countA:
            countA = countA.next
            counterA+=1
            
        while countB:
            countB = countB.next
            counterB+=1
            
        dif = abs(counterA-counterB)
        
        if counterA > counterB:
            while dif!=0:
                headA = headA.next
                dif -= 1
        
        else:
            while dif!=0:
                headB = headB.next
                dif -= 1
        
        
        while headA!=headB:
            headA = headA.next
            headB = headB.next

        return headA
    
#      Approach is find which ll has longer length, get them to be at relatively the same position and iterate through the remaining list until you find that both are same. 

#  Time complexity is O(n) and space complexity is O(1)
        
            
