'''
Time Complexity - O(1)
Space Complexity - O(1)
'''


class Solution:
    # Function to delete a node without any reference to head pointer.
    def deleteNode(self, curr_node):
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next
