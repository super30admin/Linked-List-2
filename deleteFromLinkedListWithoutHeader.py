class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        
        if not curr_node or not curr_node.next:
            return
        #code here
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next