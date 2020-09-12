# https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1


# Code:
# Approach: Rearranging the links
def deleteNode(curr_node):
    #code here
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next

# Time complexity: O(n) 
# Space complexity: O(1)
# Accepted on Leetcode: Yes.