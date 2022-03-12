# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
TC:O(1)
SC:O(1)

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        if head is None:
            return

        slow = head
        fast = head

        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        l2 = slow.next
        slow.next = None

        # reverse link list
        curr = l2
        prev = None
        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        # merege
        slow = head
        fast = prev

        dummy = slow.next
        while fast is not None:
            slow.next = fast
            fast = fast.next
            slow.next.next = dummy

            slow = dummy
            if dummy is not None:
                dummy = dummy.next





