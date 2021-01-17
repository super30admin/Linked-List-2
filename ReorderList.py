# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using two pointers. Since the list needs to be reordered, we need to find the middle element in the list.
# Then reverse the second half of the list and assign one of the pointers to the reversed list head and another pointer to original list head
# Then merge both the lists


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
            return None
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        l1 = head
        head = slow
        dummy = None
        prev = dummy
        while head:
            currentNode = head.next
            head.next = prev
            prev = head
            head = currentNode
        l2 = prev

        while l2.next:
            l1.next, l1 = l2, l1.next
            l2.next, l2 = l1, l2.next
