#TC = O(n)
#SC = O(1)
#Run on LC



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:

        if not head:
            return

        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        curr = slow

        while curr:
            t = curr.next
            curr.next = prev
            prev = curr
            curr = t

        first = head
        second = prev

        while second.next:
            tm = first.next
            first.next = second
            first = tm

            tm = second.next
            second.next = first
            second = tm

        return head

