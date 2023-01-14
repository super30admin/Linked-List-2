
# Time Complexity :O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No




class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        curr_node.data=curr_node.next.data
        curr_node.next=curr_node.next.next
        return