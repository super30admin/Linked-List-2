# TC = O(1)
# SC = O(1)
class Solution:
    # Function to delete a node without any reference to head pointer.
    def deleteNode(self, del_node):
        # code here
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next
