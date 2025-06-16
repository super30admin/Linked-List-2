"""
Time - O(1)
Space - O(1)
"""
class Solution:
    def deleteNode(self, node):
        if node is None or node.next is None:
            return
        next_node = node.next
        node.data = next_node.data
        node.next = next_node.next