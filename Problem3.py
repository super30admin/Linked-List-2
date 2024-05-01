## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

# Approach
# we cannot empty the memory location of the delete node without head.
# However since the question only asks us to delete value, traverse from the delete node to the end. change value of curr node and replace with the value of next node
# Go till 2nd last node, then replace value of 2nd last node. Set curr.next = None

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Geeks for Geeks : Yes
# Any problem you faced while coding this : No


class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,del_node):
        #code here
       
        curr = del_node
        while curr.next.next != None:
            curr.data = curr.next.data
            curr = curr.next
        
        curr.data = curr.next.data
        curr.next = None

