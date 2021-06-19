'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 160. Intersection of Two Linked Lists

# Given the heads of two singly linked-lists headA and headB, 
# return the node at which the two lists intersect. If the two linked 
# lists have no intersection at all, return null.

# For example, the following two linked lists begin to intersect at node c1:
# It is guaranteed that there are no cycles anywhere in the entire linked structure.



#-----------------
# Time Complexity: 
#-----------------
# O(M+N) - Need to go over entire list A and B once in worst case where they
#          do not intersect. M and N are no. of nodes in list A and B, resp.
#------------------
# Space Complexity: 
#------------------
# O(N): Using Hashset of size = no. of nodes in list B. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        node_set = set()
        while headB:
            node_set.add(headB)
            headB = headB.next
        
        while headA:
            if headA in node_set:
                return headA
            headA = headA.next
        return