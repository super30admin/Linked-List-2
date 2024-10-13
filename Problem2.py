# Time Complexity = O(3/2n) = O(n) | Space Complexity = O(1)

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:

        slow = head
        fast = head
        # find the middle TC - O(n/2)
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        # reverse the list - O(n/2)
        fast = self.reverse(slow.next)
        slow.next = None

        slow = head
        # rearrange  - O(n/2)
        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, head: ListNode) -> ListNode:
        prev = None
        curr = head
        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

