#TC: O(1)
#SC: O(1)

class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        if not node:
            return
        
        if not node.next: # will need the head to remove the last node
            return
        
        node.data = node.next.data
        node.next = node.next.next
        return
