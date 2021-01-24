# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # Time Complexity - O(M+N)
    # Space Complexity - O(1)
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        # If either is null, return null
        if headA == None or headB == None:
            return None
        
        ptrA = headA 
        ptrB = headB
        
        while(ptrA != ptrB):
            
            if ptrA == None: # If ptrA becomes null first, that means length of headB is grater, so we are resetting ptrA to headB
                ptrA=headB
            
            elif ptrB == None: # Similarly for ptrB
                ptrB = headA
                
            else: # Otherwise, keep on incrementing the pointer
                ptrA=ptrA.next
                ptrB = ptrB.next
                
        return ptrA
        
    
    '''
    # Time Complexity - O(M+N)
    # Space Complexity - O(1)
    # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        if headA == None or headB == None:
            return None
        
        ptrA = headA
        ptrB = headB
        
        lenA=0
        lenB=0
        
        while (ptrA):
            lenA+=1
            ptrA=ptrA.next
            
        while(ptrB):
            lenB+=1
            ptrB=ptrB.next
        
        ptrA = headA
        ptrB = headB
        
        if lenA>lenB:
            count=0            
            while count<(lenA-lenB):
                ptrA=ptrA.next
                count+=1
                
        elif lenB>lenA:
            count=0
            while count<(lenB-lenA):
                ptrB=ptrB.next
                count+=1
                
        while(ptrA!=ptrB):
            
            ptrA=ptrA.next
            ptrB=ptrB.next
            
        return ptrA
        '''