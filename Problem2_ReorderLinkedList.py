'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 143. Reorder List
# You are given the head of a singly linked-list. The list can be represented as:

# L0 → L1 → … → Ln - 1 → Ln
# Reorder the list to be on the following form:

# L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
# You may not modify the values in the list's nodes. Only nodes themselves may 
# be changed.

#-----------------
# Time Complexity: 
#-----------------
# O(N) - N/2 operations to find mid. N/2 operations to reverse
#      - N/2 operations to merge reversed linked list
#------------------
# Space Complexity: 
#------------------
# O(1): Only temporary variables used. Constant space. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #print(f"head:{head}")
        #print("Finding MID...")

        mid = head
        last = head
        while last and last.next:
            mid = mid.next
            last = last.next.next
        #print(f"MID:{mid.val}")
        
        curr = mid
        second_half = None
        
        #print(f"Second Half:{curr}")
        #print("Reversing...")
        
        while curr:
            temp = curr.next
            curr.next = second_half
            second_half = curr
            curr = temp
            
            
        #print(f"Reversed Second Half:{second_half}")
        
        first_curr = head
        second_curr = second_half
        while second_curr.next:
            temp = first_curr.next
            first_curr.next = second_curr
            first_curr = temp
            
            temp = second_curr.next
            second_curr.next = first_curr
            second_curr = temp
        
        #print(f"Head:{head}")