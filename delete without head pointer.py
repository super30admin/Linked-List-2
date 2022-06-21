# time complexity o(1)
# space complexity o(1)
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        nxtnode = curr_node.next
        curr_node.data = nxtnode.data
        curr_node.next = nxtnode.next
        nxtnode.next = None
