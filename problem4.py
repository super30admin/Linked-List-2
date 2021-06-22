# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        lenA = 0
        lenB = 0
        pointerA = headA
        pointerB = headB
        
        while headA is not None:
            headA = headA.next
            lenA +=1
        
        while headB is not None:
            headB = headB.next
            lenB +=1
        
        while lenA > lenB:
                pointerA = pointerA.next
                lenA -=1
        
        while lenB > lenA:
                pointerB = pointerB.next
                lenB -=1            
        
        while pointerA != None:
            if pointerA == pointerB:
                return pointerA
            else:
                pointerA = pointerA.next
                pointerB = pointerB.next
            
        return None

#Time complexity is O(n) and space complexity is O(1)
#Aligning the position of the two pointers at the same distance from end and incrementing them until they either hit intersection or null