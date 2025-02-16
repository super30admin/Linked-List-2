# Problem 3 : Delete without head pointer
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        # if the node is empty or the last element is none then return 
        if (node is None and node.next is None):
            return
        # Copy the data of next element in the node.
        node.data = node.next.data
        # set the node.next to pointer to next to next element
        node.next = node.next.next