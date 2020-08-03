# APPROACH  1: Intermediate solution 
# Time Complexity : O(max(a, b)), a: length of linkeed list A and b: length of the linked list B
# Space Complexity : O(max(a, b))
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Go through one list and store all the nodes in a hashset
# 2. Go through other list and check if each node is present in hashset or not
# 3. If present that's the intersection point

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        if headA is None or headB is None:
            return None
        
        hashset = set()
        while headA is not None:
            hashset.add(headA)
            headA = headA.next
            
        while headB is not None:
            if headB in hashset:
                return headB
            else:
                headB = headB.next
                
        return None
        




# APPROACH  2: Optimal solution
# Time Complexity : O(max(a, b)), a: length of linkeed list A and b: length of the linked list B
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Get the starting point of both lists same (get the length of both and set the pointer of longer list to the pos equal to the length of the smaller one)
# 2. Then traverse both lists simultaneously and check if both nodes are same or not.
# 3. If same - that's the intersection point.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        if headA is None or headB is None:
            return None
        
        len_A, len_B, curr_node = 0, 0, headA
        while curr_node is not None:
            curr_node = curr_node.next
            len_A += 1
            
        curr_node = headB
        while curr_node is not None:
            curr_node = curr_node.next
            len_B += 1
            
        flagA, flagB, count = False, False, abs(len_A - len_B)
        if len_A < len_B:
            curr_node = headB
            flagB = True
        else:
            curr_node = headA
            flagA = True
           
        curr_count = 0
        while curr_count < count:
            curr_node = curr_node.next
            curr_count += 1
            
        if flagA:
            nodeA, nodeB = curr_node, headB
        else:
            nodeA, nodeB = headA, curr_node
        
        while nodeA != nodeB:
            nodeA = nodeA.next
            nodeB = nodeB.next
            
        return nodeA
