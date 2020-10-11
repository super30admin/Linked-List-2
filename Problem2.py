# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode

import math
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        
        node_list = []
        
        while head:
            
            node_list.append(head)
            
            head = head.next
        m = len(node_list)
        for i in range(math.ceil(m / 2)):
            
            if m - 1 - i - i <= 1 :
                last = node_list[m - 1 - i]
                last.next = None
                return
            first = node_list[i]
            last = node_list[m - 1 - i]
            
            temp = first.next
            
            first.next = last
            
            last.next = temp
        
        