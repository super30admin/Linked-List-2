# // Time Complexity : o(1)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : intution to delete without extra pointers


# // Your code here along with comments explaining your approach
# idea is to copy the value of the next node to the node to be deleted and then remove the next node of the deleted node

class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        if node and node.next:
            node.data = node.next.data
            node.next = node.next.next