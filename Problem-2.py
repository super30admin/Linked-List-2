"""
Approach: Divide into 3 problems
1) find mid node
2) reverse second half
3) reorder

TC: O(n)
SC: O(1)

"""


class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        # mid node
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        # reverse 2nd half
        prev = None

        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp

        # reorder
        slow = head
        while prev.next:
            temp = slow.next
            temp2 = prev.next
            slow.next = prev
            prev.next = temp
            slow = temp
            prev = temp2