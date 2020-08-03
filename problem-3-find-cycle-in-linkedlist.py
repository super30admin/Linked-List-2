"""
Problem:
https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1

Approach:

1. copy the value of the next node
2. point the current node to next node of next node
"""

# Time Complexity : O(1) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

def deleteNode(curr_node):
    #code here
    if (curr_node.next!= None):
        curr_node.data = curr_node.next.data
        curr_node.next= curr_node.next.next
    else:
        curr_node = None
