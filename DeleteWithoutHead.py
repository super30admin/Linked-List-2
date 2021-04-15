# Time Complexity is O(1)
# Space Complexity is O(1)
# Assign the next node value to the current node and delete the next node
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        if(curr_node.next):
            curr_node.data = curr_node.next.data
            curr_node.next = curr_node.next.next
        else:
            curr_node = None