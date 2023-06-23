# Time Complexity : O(1) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to delete the node at that position and map to next node.

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        if (curr_node == None):
            return
        if(curr_node.next==None):
            curr_node=None
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next