"""
TC:O(1)
SC:o(1)
"""
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        if curr_node.next is None:
            curr_node.data = None
            curr_node.next = None
        else:
            curr_node.data = curr_node.next.data
            curr_node.next = curr_node.next.next
