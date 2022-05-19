#Approach: we dont know whats previous pointer, and we know the node to be deleted is not the tail.
# so just copy next node data to current node (overridden node to be deleted) and 
# delete next node by changing pointers of its next to curr next
#Time Complexity O(1)
#Space Complexity O(1)
#It successfully runs


class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next