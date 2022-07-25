"""
Runtime Complexity: 
O(1)- we dont traverse the whole linked list. We copy the value of next node
to the node to be deleted and update the pointers.
Space Complexity:
O(1) - no extra data structure is used to compute the solution.
Yes, the code worked.
Issues while coding- No
"""

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next