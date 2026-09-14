# https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1

# Time complexity: O(1) 
# Space complexity: O(1)
# Explanation: Just switch the next data and pointers; not a true deletion

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def deleteNode(self, del_node):
        if del_node is None or del_node.next is None:
            return

        del_node.data = del_node.next.data
        del_node.next = del_node.next.next
