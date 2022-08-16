"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach

Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
"""

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        """
        Deleting the node by replacing the curr node data with the next node data and changing the pointer of next
        node to next.next.
        Time Complexity : O(1)
        Space Complexity : O(1)
        """
        #code here
        if curr_node == None: return None
        
        temp = curr_node.next
        curr_node.data = temp.data
        curr_node.next = curr_node.next.next
        temp = None