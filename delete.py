#Time Complexity : O(1)
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        nextNode = curr_node.next
        curr_node.data = nextNode.data
        curr_node.next = curr_node.next.next
        
