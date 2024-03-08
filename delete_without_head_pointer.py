class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        if curr_node is not None and curr_node.next is not None:
            curr_node.val = curr_node.next.val
            curr_node.next = curr_node.next.next