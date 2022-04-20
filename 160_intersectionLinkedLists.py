# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA==None or headB==None : return None 
        
        lenA = 0 ;         lenB = 0 
        curr= headA 
        
        while curr!=None :
            curr= curr.next 
            lenA +=1 
            
        curr = headB 
        while curr!=None :
            curr= curr.next 
            lenB +=1 
        
        while lenA>lenB:
            lenA-=1 
            headA = headA.next 

        while lenB>lenA:
            lenB-=1 
            headB = headB.next 

        while headA!=None or headB!=None:
            if headA==headB:
                return headA
            
            headA = headA.next 
            headB = headB.next 

            
        if headA==None or headB==None:
            print("None found")
            return None 
        
        return headA 