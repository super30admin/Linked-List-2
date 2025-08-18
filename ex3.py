# Time Complexity: O(1)
# Space Complexity: O(1)

class Solution:
    def deleteNode(self, del_node):
        # Copy value from next node into current node
        del_node.data = del_node.next.data
        # Bypass the next node, effectively deleting it
        del_node.next = del_node.next.next
