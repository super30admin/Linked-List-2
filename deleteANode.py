"""
Intuition: Copy the value of the next node to the node to be deleted. 
Then modify the .next property of the node to be deleted

#####################################################################
Time Complexity : O(1) 
Space Complexity : O(1)
#####################################################################

"""
def deleteNode(self,curr_node):
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next
    