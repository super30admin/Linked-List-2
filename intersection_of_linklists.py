# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# SC : O(1)
# TC :O (m+n)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        l1 = 0 
        l2 = 0
        tA = headA
        tB = headB
        
        while(tA): # finding lengths
            l1 = l1 + 1
            tA = tA.next
        
        while(tB):
            l2 = l2 + 1
            tB = tB.next
        
        tA = headA
        tB = headB
        
        if l1 > l2: # finding greater length list
            diff = l1 - l2
            while diff and tA: # adjusting ptrs to be the same length
                tA = tA.next
                diff = diff - 1
        else:
            diff = l2 - l1
            while diff and tB:
                tB = tB.next
                diff = diff - 1
        
        flag = False
        
        while tA and tB: # Looping to check intersection
            if tA == tB:
                flag = True
                break
            tA = tA.next
            tB = tB.next
        
        if flag == True:
            return tA
        else:
            return None
        
        
        
        