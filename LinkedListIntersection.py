#TimeComplexity:O(m+n)
#SpaceComplexity:O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No
# We can solve this simply using a hashset with o(n) space complexity.However we can solve this in O(1) if we calculate the length of each list and iterate the lists from the difference of their lengths toobtain common intersection point




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        
        lenA = 0 
        lenB = 0 
        ptr1 = headA
        ptr2 = headB
        
        while(ptr1 != None):
            
            lenA +=1
            ptr1 = ptr1.next
        
        while(ptr2 != None):
            
            lenB +=1
            
            ptr2 = ptr2.next
            
        print(lenA)
        print(lenB)
        
        ptrfb = headB
        ptrfa = headA
        
        if lenB >= lenA:
            
            
            
            while(lenB != lenA ):
                
                ptrfb = ptrfb.next
                
                lenB -=1
            
            
                
                
        if lenA > lenB:
            
            
            
            while(lenA != lenB):
                
                ptrfa = ptrfa.next
                lenA -=1
                
        print(lenA)
        print(lenB)
                
        while(ptrfb != ptrfa):
            
            ptrfb = ptrfb.next
            ptrfa = ptrfa.next
        
        return ptrfb
                
            
            
            
        