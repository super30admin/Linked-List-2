"""
Approach:
 find mid and reverse second half
connect pointer alternatively from first half and second half
TC: O(n)
SP: O(1)
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
        def reverse(root):
            curr = root
            prev = None
            while curr:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
            return prev
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        rev = slow.next
        slow.next = None
        reversedHalf = reverse(rev)
        curr = head
        while curr!=slow:
            curr_next = curr.next
            rev_next = reversedHalf.next
            curr.next = reversedHalf
            reversedHalf.next = curr_next
            curr = curr_next
            reversedHalf = rev_next
        if reversedHalf:
            curr.next=reversedHalf




        