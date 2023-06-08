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
        if not head.next:
            return head
        # Optimised Approach
        # Time : O(n)
        # Space : O(1)
        # Find Mid-Point of LL
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # print(slow.val)
        fast = slow.next
        slow.next = None

        # Reverse the second half of the Linked List
        curr = fast
        prev = None
        fast = curr.next
        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        # print(curr)
        # print(head)
        # Merge First half LL and Reversed Second half LL
        slow = head
        fast = curr
        temp = slow.next
        while temp:
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            temp = temp.next
        # print(slow)
        # print(fast)
        if fast:
            slow.next = fast

        return head
