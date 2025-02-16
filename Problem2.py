# Problem 2 : Reorder List
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        # Find middle element of the list using slow and fast pointer
        slow = fast = head
        while (fast and fast.next):
            # slow pointer will move by one position
            slow = slow.next
            # fast pointer will move by two position
            fast = fast.next.next
        
        # Reverse second half
        # slow pointer will point to end element of the first list so store the next element of slow pointer to curr
        curr = slow.next
        slow.next = None
        prev = None
        while(curr):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        # Merged the two list
        # head of the first list
        firstHalf = head
        # head of the second list
        secondHalf = prev
        while (secondHalf):
            temp = firstHalf.next
            firstHalf.next = secondHalf
            secondHalf = secondHalf.next
            firstHalf.next.next = temp
            firstHalf = temp


        