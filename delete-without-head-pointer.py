# Time : O(1)
# Space: O(1)
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        temp = node.next
        node.data = node.next.data
        node.next = node.next.next
        temp = None 