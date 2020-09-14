# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        #Given that we are at current code, we can only use .next() to make any changes forward
        #1. copy the value of next element to the current element
        #2. Now change the curr.next pointer to point at curr.next.next
        #3. This means we have deleted the neighboring node by copying the value of next node and moving our next pointer to next node's next
        node.val = node.next.val 
        node.next = node.next.next
        
        