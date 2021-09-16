# // Time Complexity :O(n) 
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        A=0
        B=0
        Aptr=headA
        Bptr=headB
        while Aptr.next:
            Aptr=Aptr.next
            A+=1
        A+=1
    
        while Bptr.next:
            Bptr=Bptr.next
            B+=1
        B+=1
        
        while A>B:
            headA=headA.next
            A-=1
            
        while B>A:
            headB=headB.next
            B-=1
            
        while(headB):
            
            if headA is headB:
                return headA
            headA=headA.next
            headB=headB.next
        
            
            
            
        