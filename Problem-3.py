# Delete Node without head pointer
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
def deleteNode(self,curr_node):
        # Copy the next node's value to current node
        curr_node.data = curr_node.next.data    

        # Delete the next node 
        curr_node.next = curr_node.next.next