# Time Complexity : O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        temp=curr_node.next
        if(temp is not None):
            curr_node.data=temp.data
            curr_node.next=temp.next
            temp.next=None
        else:
            curr_node.data=None