"""
Name: Srinidhi Bhat 
Did it run on LC: Yes

Time Complexity: O(n) - Traversal of the Linked List
Space Complexity: O(n) - extra space for the hashmap 

Logic: 
In a hashmap store reference of the node of list A
In second traversal go through list B and search id node reference is 
there in hashmap, if it is, that is the intersection point
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        hash_table_A = {}
        tempA = headA
        
        while tempA!=None:
            hash_table_A[tempA] = True
            tempA = tempA.next
        
        tempB = headB
        while tempB!=None:
            if tempB in hash_table_A:
                return tempB
            
            tempB = tempB.next
        
        return None