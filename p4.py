# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        
        lenA=0
        lenB=0
        
        pA=headA
        while(pA!=None):
            pA=pA.next
            lenA+=1
            
        pB=headB
        while(pB!=None):
            pB=pB.next
            lenB+=1
        
        
        ##rest pA and pB to head
        pA=headA
        pB=headB
        if lenA>=lenB:
            offset=lenA-lenB
            #print(offset)
            while(pA!= None and pA.next!=None and offset!=0):
                pA=pA.next
                offset-=1
        
        if lenB>=lenA:
            offset=lenB-lenA
            #print(offset)
            while(pB!=None and pB.next!=None and offset!=0):
                pB=pB.next
                offset-=1
                
        #print(pA)
        #print(pB)
        
        while(pA!=None and pB!=None):
            
            if pA==pB:
                #print(pA.val)
                return pA
            
            pA=pA.next
            pB=pB.next
            
