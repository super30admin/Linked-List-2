# Time complexity : O(1)
# Space complexity : O(1)

# The code ran on Leetcode

# Copy data from the next node and update the next pointer to skip the current next node

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        next_node = curr_node.next
        if next_node == None:
            curr_node = None
        else:
            curr_node.data = next_node.data
            curr_node.next = curr_node.next.next
