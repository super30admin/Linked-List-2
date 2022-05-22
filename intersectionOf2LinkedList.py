'''
Time Complexity : 0(n) -- all the  nodes count in listA and listB
Space Complexity : 1 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        # Get the length of listA
        countA = 0
        currentA = headA
        while currentA != None:
            countA+=1
            currentA = currentA.next
            continue
        
        # Get the length of listB
        countB = 0
        currentB = headB
        while currentB != None:
            countB+=1
            currentB = currentB.next
            continue
        
        # cal the diff
        diff = abs(countA-countB)
        
        # move the ptrA and ptrB based upon greater count
        ptrA = headA
        ptrB = headB
        if countA > countB:
            # Move ptrA "diff" nodes ahead
            while diff != 0:
                ptrA = ptrA.next
                diff -=1
                continue
            
        else:
            # Move ptrB "diff" nodes ahead
            while diff != 0:
                ptrB = ptrB.next
                diff -=1
                continue
        
        # Iterate both ptrA and ptrB till either reaches None
        while ptrA != None and ptrB != None:
            
            if ptrA == ptrB:
                # Its a match
                return ptrA
            
            ptrA = ptrA.next
            ptrB = ptrB.next
            
            continue
        
        return None