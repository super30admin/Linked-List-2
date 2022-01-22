class Solution:
    #Function to delete a node without any reference to head pointer.

    # Time Complexity - O(1)
    # Space Complexity - O(1)
    # Here, we copy the next node's data to the node that is to be deleted and we move one step forward so that
    # conventional methods of deletion can be applied.
    def deleteNode(self,curr_node):
        curr = curr_node
        temp = curr.next

        curr.data = temp.data
        curr.next = temp.next