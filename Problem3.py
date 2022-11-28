#Time Complexity :- O(1)
#Space Complexity :- O(1)
# Approach :- Copied the next reference in current until we reach end and once we do that we point the current to None 


class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        if curr_node.next is not None:
            nextNode = curr_node.next
        while nextNode:
            curr_node.data = nextNode.data
            if nextNode.next is None:
                break    
            curr_node = curr_node.next
            nextNode = nextNode.next
        #code here
        curr_node.next = None