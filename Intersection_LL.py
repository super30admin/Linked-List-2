# Time Complexity : O(N) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
    
        lenA = 0
        lenB= 0
        
        # calculate lenA
        curr = headA
        while curr != None:
            curr = curr.next
            lenA += 1
         
        # calculate lenA 
        curr = headB
        while curr != None:
            curr = curr.next
            lenB += 1
        
        #bring to correct position when we substract lenA - lenB if lenA > lenB
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
       
        #bring to correct position when we substract lenA - lenB if lenB > lenA
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
        
        # Just move one step from headA and headB until it intersects
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA
        
        
