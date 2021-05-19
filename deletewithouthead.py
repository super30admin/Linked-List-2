class Solution:
    """
    Tc : O(N)
    SC : O(1)
    approach : copy the value of next node to the current until we reach the end and delete last one
    """
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        prev = None
        while curr_node.next:
            curr_node.data = curr_node.next.data
            prev = curr_node
            curr_node = curr_node.next
        prev.next = None