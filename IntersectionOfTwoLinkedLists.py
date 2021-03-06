# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# TC: O(N + M)
# SC: O(1)
# LeetCode: Y(https://leetcode.com/problems/intersection-of-two-linked-lists/)
# Approach: Get the length of the two Linked Lists, and get the difference between two lengths
#           Move the current pointer of the larger Linked List by that difference number of nodes
#           Then move the two nodes one at a time in the two Linked Lists
#           If the two nodes meet then that node is the node of intersection
#           If the two nodes don't meet then there is no intersection of two Linked lists
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        lengthA = self.calculateLengthOfLinkedList(headA)
        lengthB = self.calculateLengthOfLinkedList(headB)
        
        currentA,currentB = headA, headB
        
        if lengthA > lengthB:
            for i in range(abs(lengthA - lengthB)):
                currentA = currentA.next
        else:
            for i in range(abs(lengthA - lengthB)):
                currentB = currentB.next
                
        while currentA:
            if currentA == currentB:
                return currentA
            currentA = currentA.next
            currentB = currentB.next
            
        return None
                
            
        
    def calculateLengthOfLinkedList(self, head: ListNode) -> int:
        length = 0
        
        current = head
        
        while current:
            length += 1
            current = current.next
            
        return length
        
