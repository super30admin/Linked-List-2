#Time Complexity = O(1)
#Space Complexity = O(1)
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, del_node):
        if not del_node or not del_node.next:
            return
        del_node.data = del_node.next.data
        temp = del_node.next
        del_node.next = del_node.next.next
        del temp