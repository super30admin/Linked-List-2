# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        currA = headA
        currB = headB
        
        while currA is not None:
            currA=currA.next
            lenA+=1
            
        while currB is not None:
            currB= currB.next
            lenB+=1
            
        currA, currB = headA, headB
        
        if lenA>lenB:
            count = lenA-lenB
            while count>0:
                currA = currA.next
                count-=1
                
        elif lenB>lenA:
            count = lenB-lenA
            while count>0:
                currB = currB.next
                count-=1
        
        while currB!=currA:
            currB = currB.next
            currA = currA.next
            
        return currA
            
        