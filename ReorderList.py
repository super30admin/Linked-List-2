# Time complexity is O(n)
# space complexity is O(1)


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head

        while (fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next

        # resverse the second half
        fast = self.reverse(slow.next)
        slow.next = None

        # merging the list

        slow = head
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, node):
        prev = None
        curr = node
        while (curr):
            curr_next = curr.next
            curr.next = prev
            prev = curr
            curr = curr_next
        return prev
