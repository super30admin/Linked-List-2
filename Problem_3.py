"""
## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
"""

class Solution:
    # Function to delete a node in the middle of a singly linked list.
    #TC: O(1) SC: O(1)
    def deleteNode(self, node):
        #code here
     
        node.data= node.next.data
      
        node.next = node.next.next