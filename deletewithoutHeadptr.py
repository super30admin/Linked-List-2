# Time Complexity : O(1) 
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        temp = curr_node.next
        curr_node.data=temp.data
        curr_node.next = temp.next