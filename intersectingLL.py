# Time Complexity : O(N) 
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        if headA==None or headB==None:
            return None
        lenA=0
        lenB=0
        cA = headA
        cB = headB
        while(cA!=None):
            lenA+=1
            cA = cA.next
        
        while(cB!=None):
            lenB+=1
            cB = cB.next
        cA=headA
        cB=headB
        while(lenA>lenB) :
            cA=cA.next
            lenA-=1
            
        while(lenA<lenB) :
            cB=cB.next
            lenB-=1
        
        while(cA!=cB):
            cA=cA.next
            cB=cB.next
        return cB
            
            
            
        