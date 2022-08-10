# Time Complexity : O(N) where N is number of nodes in the linked list
# Space Complexity : O(1)



class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        if curr_node is None: return
        prev = None
        while curr_node.next is not None:
            nex = curr_node.next
            curr_node.data = nex.data
            prev = curr_node
            curr_node = curr_node.next

        prev.next = None 