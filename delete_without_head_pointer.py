class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #storing the node next to given node in a pointer.
        temp=curr_node.next
        
        #copying the data of pointer in the given current node.
        curr_node.data=temp.data
        
        #storing the next node to pointer in link part of current node.
        curr_node.next=temp.next
        
        #freeing memory.
        del temp

