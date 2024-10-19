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
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        fast = self.reverse(slow.next)
        slow.next = None

        slow = head
        while fast:
            temp1 = slow.next
            temp2 = fast.next
            slow.next = fast
            fast.next = temp1
            slow = temp1
            fast = temp2

    def reverse(self, head):
        prev = None
        curr = head
        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev


# time complexity is O(n)
# space complexity is O(1)
