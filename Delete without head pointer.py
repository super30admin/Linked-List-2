# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# we point current node data to current node next data
# we point current node next to current node next next

def deleteNode(curr_node):
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next