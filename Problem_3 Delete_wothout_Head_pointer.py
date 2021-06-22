# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : NA
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach


# The reference of a node is given- we can delete without head pointer. Cant do it for last node.
def delete(node):
    if node == None or node.next== None:
        return
    # copy the next node value
    node.val = node.next.val
    # bypass repeat node value
    node.next = node.next.next