# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if (headA==None or headB==None):
            return None
        tempA= headA
        tempB= headB
        countA= 1
        countB= 1
        while(tempA!=None):
            tempA = tempA.next
            countA+=1
        while(tempB!=None):
            tempB = tempB.next
            countB+=1
        tempA,tempB=headA,headB
        if countA>countB:
            diff = countA-countB
            count=0
            while(count<diff):
                tempA= tempA.next
                count+=1
                
        if countA<countB:
            diff = countB-countA
            count=0
            while(count<diff):
                tempB=tempB.next
                count+=1
                
        while(tempA!=None ):
            if(tempA==tempB):
                return tempB
            tempA=tempA.next
            tempB= tempB.next
            
        return None
        
    
        
        