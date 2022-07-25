# Time Complexity : O(N)  //Where n is the size of the list we are iterating
#  Space Complexity : O(1)  //We are not using any extra space
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        #Base caseif headA and headB both are null
        if not headA or not headB:
            return None
        
        #Declare variables to keep trackof the path traversed
        lenA,lenB = 0,0
        
        #Traverse the headA using current and repeat the same for headB
        curr = headA    
        while curr:
            curr = curr.next
            lenA+=1
        
        curr = headB
        while curr:
            curr = curr.next
            lenB+=1
            
        #Move the headA pointer till the lenghth of the A doesnt diminish below the length of b and vice versa 
        while lenA > lenB:
            headA = headA.next
            lenA-=1
            
        while lenB > lenA:
            headB = headB.next
            lenB -=1
        #If both heads are not equal move them both and return any one of them
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA