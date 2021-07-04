# Time Complexity :O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
def deleteNode(curr_node):
    #code here
    #if there is a next node take its val  and delete the next node
    if curr_node.next:
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next
    else:
        #else change currnode to None
        curr_node = None