class Solution:
"""Time Complexity-O(1)
Space Complexity-O(1)"""
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        removeNode=curr_node.next
        curr_node.data=curr_node.next.data
        curr_node.next=curr_node.next.next
        removeNode.next=None
        
