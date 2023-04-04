# Time Complexity : O(1)
# Space Complexity : O(1)
class Node:
    def __init__(self, data): 
        self.data = data
        self.next = None

class Solution:
    def deleteNode(self, curr_node):
        if curr_node is None:
            return
        if curr_node.next is None:
            curr_node = None
            return
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next
