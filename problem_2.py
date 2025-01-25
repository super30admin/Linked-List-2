"""
problem 2: Reorder List
TC: O(n)
SC: O(1)
Approach: 1. split the list in two parts
            2. reverse the second half
            3. merge the list
"""

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
        if not head or not head.next:
            return head

        # 1. split the list in two parts

        slow = head
        fast = head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # 2. reverse the second half

        fast = self.reverse_list(slow.next)

        # merge the list
        slow.next = None
        slow = head

        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse_list(self, head):
        if not head or not head.next:
            return head

        prev = None
        curr = head
        fast = curr.next

        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev
        return curr
