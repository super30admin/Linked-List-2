# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        #1. Get the length ofboth linked lists
        len1, len2 = 0, 0
        h1, h2 = headA, headB
        
        while h1 !=None:
            len1 += 1
            h1 = h1.next
            
        while h2 !=None:
            len2 += 1
            h2 = h2.next
            
        #2. Start from the longer list, and while the difference is greater than 0, move the longer list's pointer ahead
        
        h1, h2 = headA, headB
        
        if len1>len2:
            while len1 != len2:
                len1 -=1
                h1 = h1.next    
        else:
            while len1 != len2:
                len2 -=1
                h2 = h2.next  
                
        #3. Now, the sizes of both lists are equal from the nodes where h1 & h2 are at. Hence,we can start moving both pointers ahead until we find a matching value(intersection)
        while h1 != None and h2!=None:
            if h1 == h2:
                return h1
            h1 = h1.next
            h2 = h2.next
        
        #4. if we dont find anything and the lists don't intersect return None
        return None
        
            
            
        