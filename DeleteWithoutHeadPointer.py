"""
Time Complexity : O(1)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def deleteNode(self, node):
        
        # Storing the node next in a pointer.
        temp = node.next
        
        # Copying the data of pointer in current node.
        node.data = temp.data
        # Storing the next pointer in the node
        node.next = temp.next
        
        #freeing memory.
        del temp