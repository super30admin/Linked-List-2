# TC : O(1)
# SC : O(1)
# ABLE TO RUN IN GEEKS FOR GEEKS
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        # print(curr_node.data)
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next