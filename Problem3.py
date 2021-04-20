## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next