# Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
# // Time Complexity :O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
def deleteNode(node):
    # removing the next node and copying its element to the given node
    removig_node = node.next
    node.val = removig_node.val
    node.next = removig_node.next
    removig_node.next = None
