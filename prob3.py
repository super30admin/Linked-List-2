# Time Complexity :O(1)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,node):
        #code here
        node.data = node.next.data
        node.next = node.next.next