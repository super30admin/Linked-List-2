# https://leetcode.com/problems/reorder-list/description/

# Time Complexity: O(n)
# Space Complexity: O(1)

# This problem is about reordering a linked list. We are given a single linked list. The reordering looks like a zigzag pattern
# first node points to last node, then (last-1)th node points to second node and so on. We can implement this by using slow and fast pointers
# First get the middle pointer using slow and fast pointer. When fast reaches the lastnode (fast.next == None), then the wherever the slow points
# to becomes the middle node. The second half of the linked list can be reversed. Write a reverse linkedlist function and use it to reverse the second
# half. Now we can use slow and fast pointers to move in a zigzag pattern to return the resultant list.

# Example: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> None
# Mid becomes 4, second half of the array is 5 -> 6 -> 7
# After reversing the second half. 
# 1 -> 2 -> 3 -> 4
# 7 -> 6 -> 5 
# Reordered list = 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        fast = head
        slow = head

        # get the middle
        while fast is not None and fast.next is not None:
            fast = fast.next.next
            slow = slow.next

        fast = self.reverse(slow.next)
        slow.next = None

        slow = head
       
        while slow is not None and fast is not None:
            temp = slow.next
            slow.next = fast
            temp1 = fast.next
            fast.next = temp
            slow = temp
            fast = temp1
              
    def reverse(self, head):
        prev = None
        curr = head
        
        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev