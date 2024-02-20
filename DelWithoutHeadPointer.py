# Time complexity is O(1)
# Space complexity is O(1)


class Solution:
    # Function to delete a node without any reference to head pointer.
    def deleteNode(self, curr_node):
        temp = curr_node.next
        curr_node.data = temp.data
        curr_node.next = temp.next
        temp.next = None
