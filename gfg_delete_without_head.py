class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        while curr_node.next.next!=None:
            curr_node.data = curr_node.next.data 
            curr_node = curr_node.next 
        
        curr_node.data = curr_node.next.data 
        curr_node.next = None