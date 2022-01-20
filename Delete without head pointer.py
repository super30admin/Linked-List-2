# Time Complexity :
# TC: O(1)

# Space Complexity :
# SC: O(1)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# In order to delete a node in a LL we should have pointer pointing to the node just behind the node to be deleted
# Here our pointer is at the node to be deleted
# So we swap the value of the node to be deleted with its next node for example
# input: 1-->2-->3P-->4-->None  and we have to deleted 3
# After swaping 1-->2-->4P-->3-->None and here our pointer is pointing to 4 
# Now we can just point the next of 4 to next of its next element

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        # TC: O(1)
        # SC: O(1)
        
        #code here
        curr_node.data, curr_node.next.data = curr_node.next.data, curr_node.data
        curr_node.next = curr_node.next.next