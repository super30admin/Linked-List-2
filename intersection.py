# Time Complexity O(n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getLength(self, root):
        count = 0
        head = root
        while head:
            count += 1
            head = head.next
        return count
    
    def findNode(self, larger, smaller, llen, slen):
        while llen > slen:
            larger = larger.next
            llen -= 1
        while larger != smaller:
            larger = larger.next
            smaller = smaller.next
        return smaller
        
        
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA:
            return None
        lenA = self.getLength(headA)
        lenB = self.getLength(headB)
        if lenA > lenB:
            return self.findNode(headA, headB, lenA, lenB)
        else:
            return self.findNode(headB, headA, lenB, lenA)
        