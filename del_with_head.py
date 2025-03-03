#time: O(1)
#space: O(1)
#duplicate the next pointer val to current val and skip the next pointer
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        node.data= node.next.data
        node.next= node.next.next
