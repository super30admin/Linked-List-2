class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def deleteNode(self, del_node):
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next