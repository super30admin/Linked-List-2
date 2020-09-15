"""
Write a program to find the node at which the intersection of two singly linked lists begins.

Time = O(m+n) where m = length of LinkedlistA , n = length of linkedlistB
space : O(m) or O(n)
Successfully excecuted on leetcode


Approach --
1. Create a dictionary to store each visited node in headA node
2. Iterate through headB node and check if the node presents in dictionary, return if it does

"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class InterSection:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
     
        dictionary = {}
        
        while headA:
            dictionary[headA] = headA
            headA = headA.next
        while headB:
            if headB in dictionary:
                return headB
            headB = headB.next
        
        