# 143. Reorder List

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# Find the middle of the linked list.
# Reverse the second half of the linked list.
# Merge the two halves alternatively.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow = head
        fast = head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        curr = slow.next
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        slow.next = None
        
        fast = head
        slow = prev

        while fast and slow:
            temp = slow.next
            slow.next = fast.next
            fast.next = slow
            slow = temp
            fast = fast.next.next
        

        