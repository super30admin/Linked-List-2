# Time Complexity : O(n), where n is the number of nodes in the list
# Space Complexity : O(1), in-place manipulation of the list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def reverse(self, head):
        # Standard iterative reversal of a singly linked list
        prev = None
        curr = head
        while curr:
            temp_next = curr.next
            curr.next = prev
            prev = curr
            curr = temp_next
        return prev

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        if not head or not head.next:
            return

        # Step 1: Use slow and fast pointers to find the middle
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse the second half of the list
        second = self.reverse(slow.next)
        slow.next = None  # Cut the list in half

        # Step 3: Merge the two halves
        first = head
        while second:
            temp1, temp2 = first.next, second.next
            first.next = second
            second.next = temp1
            first = temp1
            second = temp2
