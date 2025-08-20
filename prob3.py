# Delete a node without head pointer
# We are fecthing the next node of the node to be deleted and copying its value to the current node.
# Then we are linking the current node to the next of the next node.
# Time Complexity: O(1)
# Space Complexity: O(1)

class Solution:
    def deleteNode(self, del_node):
        next_node = del_node.next
        del_node.data = next_node.data
        del_node.next = next_node.next