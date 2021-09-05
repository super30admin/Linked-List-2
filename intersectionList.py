# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    """
    TC: O(sum of length of both the lists) = O(n)
    SC: O(1)
    """
    def lenOfList(self, curr):
        size = 0
        
        while curr != None:
            size += 1
            curr = curr.next
        
        return size
        
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        # 1. base case
        if headA == None and headB == None:
            return None
        
        # 2. when both the lists are not empty
        
        # calculate the length of both the lists
        sizeA = self.lenOfList(headA)
        sizeB = self.lenOfList(headB)
        
        # move the head of the largest list
        currA = headA
        currB = headB
        
        if sizeA > sizeB:
            diff = sizeA - sizeB
            
            while diff != 0:
                currA = currA.next
                diff -= 1
        elif sizeA < sizeB:
            diff = sizeB - sizeA
            
            while diff != 0:
                currB = currB.next
                diff -= 1
            
        # match the node's address to find the intersection
        
        while currA != None and currB != None:
            
            if currA == currB:
                return currA
            
            currA = currA.next
            currB = currB.next
        
        return None