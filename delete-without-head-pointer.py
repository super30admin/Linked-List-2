# Time Complexity: O(1)
# Space Complexity: O(1)
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        temp=curr_node.next.data
        curr_node.next=curr_node.next.next
        curr_node.data=temp
