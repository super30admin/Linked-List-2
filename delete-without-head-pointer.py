#Time Complexity : O(n)
#Space Complexity : O(1)
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        if node is None or node.next is None:
            return
        next_node = node.next
        node.data = next_node.data
        node.next = next_node.next