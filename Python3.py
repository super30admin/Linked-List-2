# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : no
# Any problem you faced while coding this : no
# Problem Name: Reverse Linked List


class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next