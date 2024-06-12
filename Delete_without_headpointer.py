# Time complexity --> o(1)
# space complexity --> o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
def deleteNode(curr_node):
    #code here
    curr_node.data=curr_node.next.data
    curr_node.next=curr_node.next.next