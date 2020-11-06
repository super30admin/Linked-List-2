#Time Complexity : O(1)
#Space Complexity : O(1)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Change value of curr_node to the value of curr's next node and then point the curr's next to curr's next.next, thus deleting the curr node.

#Your code here along with comments explaining your approach

# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

def deleteNode(curr_node):
    #code here
    #code here
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next
