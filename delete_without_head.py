# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Geeks for Geeks : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# copy val and next from next pointer to current node

def deleteNode(curr_node):
    #code here
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next