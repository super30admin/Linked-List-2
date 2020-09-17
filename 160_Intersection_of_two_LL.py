# Leetcode problem link : https://leetcode.com/problems/intersection-of-two-linked-lists/
# Time Complexity : O(n)
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(n^2) => Check each node in forst linked list for every other ndoe in the second linked list
    
        Optimized approach: O(m+n) => Get length of both the linked list and move the head of the linked list with more elements forward till both the size are equal and then compare one by one each node in the linked list. If node is same return the node else return null
    '''  

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # get size of both linked list
        aSize = self._getLength(headA)
        bSize = self._getLength(headB)
        
        # create dummy heads so that input heads are not not modified
        dummyA = headA
        dummyB = headB
        
        # move the pointer of the linked list 
        if aSize > bSize:
            while (aSize != bSize):
                dummyA = dummyA.next
                aSize -= 1
        elif aSize < bSize:
            while (aSize != bSize):
                dummyB = dummyB.next
                bSize -= 1 
        
        while dummyA and dummyB:
            if dummyA == dummyB:
                return dummyA
            dummyA = dummyA.next
            dummyB = dummyB.next
        return None
    
    def _getLength(self,head):
        count = 0
        while head:
            count += 1
            head = head.next
        return count
        