# Copy next node's data to current node.
# Connect current node's next to next of next.
# Delete next node.

# Time Complexity: O(1)
# Space Complexity: O(1)

class Solution:
   
    def deleteNode(self, del_node):

        del_node.data = del_node.next.data
        
        del_node.next = del_node.next.next
