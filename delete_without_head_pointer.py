# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No (GeeksforGeeks)
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
def deleteNode(del_node):
    # Since we don't have access to the previous node or head,
    # we copy the data from the next node into the current node,
    # then bypass the next node.

    if del_node is None or del_node.next is None:
        return  # Can't delete the last node this way

    del_node.data = del_node.next.data
    del_node.next = del_node.next.next
