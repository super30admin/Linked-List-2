# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return
        slow = head
        fast = head

        while fast.next is not None and fast.next.next is not None:  # find mid of linked list
            slow = slow.next
            fast = fast.next.next

        reversedhead = self.helper(slow.next)  # reverse second half of linked list
        slow.next = None

        fast = reversedhead
        slow = head

        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def helper(self, head):
        prev = None
        curr = head
        fast = curr.next

        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev
        return curr