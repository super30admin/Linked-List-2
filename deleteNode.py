"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Not on leetcode
Any problem you faced while coding this : none
"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.data = x
        self.next = None
        
class Solution:
    def delete(self, curr_node):
        while curr_node.next:
            curr_node.data = curr_node.next.data
            curr_node = curr_node.next
            
        curr_node = None

# testing
h = ListNode(1)
h.next = ListNode(2)
h.next.next = ListNode(3)
h.next.next.next = ListNode(4)
h.next.next.next.next = ListNode(5)

n = 3
i = 0

while i < n:
    h = h.next
    i += 1
print(h.data)
s = Solution()
s.delete(h)