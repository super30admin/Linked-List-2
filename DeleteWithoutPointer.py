# Time Complexity : O(N)  //Where n is the size of the list we are traversing
#  Space Complexity : O(1)  //We are not using any extra space
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,currNode):
        if currNode.next:
            next=currNode.next
            next_data=next.data
            currNode.data=next_data
            currNode.next=currNode.next.next # copying the data of following node into current node 
            # and deleting the following node
        else:
            currNode.val=None